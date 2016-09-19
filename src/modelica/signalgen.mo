block signalgen "Move as fast as possible from start to end position within given kinematic constraints with output signals q, qd=der(q), qdd=der(qd)"
  import SI = Modelica.SIunits;
  import Cv = Modelica.SIunits.Conversions;
  parameter Real q_begin = 0;
  parameter Real q_all[:] = {20, 40, -20} "All position";
  parameter Real q_time[:] = {6, 8, 10} "positions start time";
  parameter Real qd_max = 10 "Maximum velocities der(q)";
  parameter Real qdd_max = 100 "Maximum accelerations der(qd)";
  extends Modelica.Blocks.Icons.Block;
  final parameter Integer nStep = max([size(q_all, 1); size(q_time, 1)]) "Number of output signals (= dimension of q, qd, qdd, moving)";
  Real control[nStep];
  Real control2[nStep + 1];
  Real controls;
  Integer whathappening;
  Boolean endcondition;
  Modelica.Blocks.Interfaces.RealOutput q "Reference position of path planning" annotation(Placement(transformation(extent = {{100, 70}, {120, 90}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput qd "Reference speed of path planning" annotation(Placement(transformation(extent = {{100, 20}, {120, 40}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput qdd "Reference acceleration of path planning" annotation(Placement(transformation(extent = {{100, -40}, {120, -20}}, rotation = 0)));
  Modelica.Blocks.Interfaces.BooleanOutput moving "= true, if end position not yet reached; = false, if end position reached or axis is completely at rest" annotation(Placement(transformation(extent = {{100, -90}, {120, -70}}, rotation = 0)));
  Real p_q_all[nStep] = if size(q_all, 1) == 1 then ones(nStep) * q_all[1] else q_all;
  Real p_q_time[nStep + 1] = if size(q_time, 1) == 1 then ones(nStep + 1) * q_time[1] else cat(1, q_time, {100});
  Integer current;
  constant Real eps = 0.000001;
  stategraph doboz1(qd_max = qd_max, qdd_max = qdd_max, begin = q_begin) annotation(Placement(visible = true, transformation(origin = {12, 28}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition2(condition = false) annotation(Placement(visible = true, transformation(origin = {38, -16}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition3(condition = p_q_time[current] <= time) annotation(Placement(visible = true, transformation(origin = {-6, -16}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.Blocks.Logical.Timer timer1 annotation(Placement(visible = true, transformation(origin = {-14, -74}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.Blocks.Logical.GreaterEqualThreshold greaterEqualThreshold1(threshold = 0.001) annotation(Placement(visible = true, transformation(origin = {-54, -74}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.StateGraph.InitialStepWithSignal initialStepWithSignal1 annotation(Placement(visible = true, transformation(origin = {-30, -16}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.StateGraph.TransitionWithSignal transitionWithSignal1 annotation(Placement(visible = true, transformation(origin = {-66, -16}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  inner Modelica.StateGraph.StateGraphRoot stateGraphRoot annotation(Placement(visible = true, transformation(origin = {-70, 70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
equation
  connect(greaterEqualThreshold1.y, transitionWithSignal1.condition) annotation(Line(points = {{-65, -74}, {-76, -74}, {-76, -52}, {-66, -52}, {-66, -28}, {-66, -28}}, color = {255, 0, 255}));
  connect(transitionWithSignal1.outPort, doboz1.inPort) annotation(Line(points = {{-67.5, -16}, {-71.25, -16}, {-71.25, 28}, {-4, 28}}));
  connect(initialStepWithSignal1.outPort[1], transitionWithSignal1.inPort) annotation(Line(points = {{-40.5, -16}, {-40.5, -15}, {-62, -15}, {-62, -16}}));
  connect(initialStepWithSignal1.active, timer1.u) annotation(Line(points = {{-30, -27}, {-30, -27}, {-30, -52}, {6, -52}, {6, -74}, {0, -74}, {0, -74}}, color = {255, 0, 255}));
  connect(transition3.outPort, initialStepWithSignal1.inPort[1]) annotation(Line(points = {{-7.5, -16}, {-19, -16}}));
  connect(timer1.y, greaterEqualThreshold1.u) annotation(Line(points = {{-25, -74}, {-42, -74}}, color = {0, 0, 127}));
  connect(doboz1.suspend[1], transition3.inPort) annotation(Line(points = {{4.5, 12.5}, {4.25, 12.5}, {4.25, 10.5}, {4, 10.5}, {4, -9.375}, {-2, -9.375}, {-2, -16}}));
  connect(doboz1.outPort, transition2.inPort) annotation(Line(points = {{27.5, 28}, {27.5, 27.5}, {27.5, 27.5}, {27.5, 27}, {41.5, 27}, {41.5, 5.5}, {41.5, 5.5}, {41.5, -5.25}, {41.5, -5.25}, {41.5, -16}}));
  connect(transition2.outPort, doboz1.resume[1]) annotation(Line(points = {{36.5, -16}, {36.5, -17}, {20, -17}, {20, 12}}));
  connect(doboz1.q, q) annotation(Line(points = {{28, 36}, {66, 36}, {66, 80}, {110, 80}}, color = {0, 0, 127}));
  connect(doboz1.qd, qd) annotation(Line(points = {{28, 31}, {74, 31}, {74, 30}, {110, 30}}, color = {0, 0, 127}));
  connect(doboz1.qdd, qdd) annotation(Line(points = {{28, 25}, {74, 25}, {74, -30}, {110, -30}}, color = {0, 0, 127}));
  connect(doboz1.moving, moving) annotation(Line(points = {{28, 20}, {66, 20}, {66, -80}, {110, -80}}, color = {255, 0, 255}));
  connect(doboz1.controls, controls);
  when q + eps > controls and q - eps < controls and current == nStep + 1 then
    endcondition = true;
  end when;
  for i in 1:nStep - 1 loop
    if time >= p_q_time[i] and time < p_q_time[i + 1] then
      control[i] = 1;
    else
      control[i] = 0;
    end if;
  end for;
  if time >= p_q_time[nStep] then
    control[nStep] = 1;
  else
    control[nStep] = 0;
  end if;
  if time <= p_q_time[1] + 0.01 then
    control2[1] = 1;
  else
    control2[1] = 0;
  end if;
  for i in 1:nStep - 1 loop
    if time >= p_q_time[i] + 0.01 and time < p_q_time[i + 1] + 0.01 then
      control2[i + 1] = 1;
    else
      control2[i + 1] = 0;
    end if;
  end for;
  if time >= p_q_time[nStep] + 0.01 then
    control2[nStep + 1] = 1;
  else
    control2[nStep + 1] = 0;
  end if;
  if initialStepWithSignal1.active then
    whathappening = 10;
  else
    whathappening = doboz1.whathappening;
  end if;
  current = control2 * linspace(1, nStep + 1, nStep + 1);
  controls = control * p_q_all;
  annotation(defaultComponentName = "signalgen", Icon(coordinateSystem(preserveAspectRatio = true, extent = {{-100, -100}, {100, 100}}), graphics = {Line(points = {{-80, 78}, {-80, -82}}, color = {192, 192, 192}), Polygon(points = {{-80, 90}, {-88, 68}, {-72, 68}, {-80, 88}, {-80, 90}}, lineColor = {192, 192, 192}, fillColor = {192, 192, 192}, fillPattern = FillPattern.Solid), Line(points = {{-90, 0}, {17, 0}}, color = {192, 192, 192}), Line(points = {{-80, 0}, {-70, 0}, {-70, 70}, {-50, 70}, {-50, 0}, {-15, 0}, {-15, -70}, {5, -70}, {5, 0}, {18, 0}}, color = {0, 0, 0}, thickness = 0.25), Text(extent = {{34, 96}, {94, 66}}, lineColor = {0, 0, 0}, textString = "q"), Text(extent = {{40, 44}, {96, 14}}, lineColor = {0, 0, 0}, textString = "qd"), Text(extent = {{32, -18}, {99, -44}}, lineColor = {0, 0, 0}, textString = "qdd"), Text(extent = {{-32, -74}, {97, -96}}, lineColor = {0, 0, 0}, textString = "moving")}), Documentation(info = "<html>
<p>
The goal is to move as <b>fast</b> as possible from start position <b>q_begin</b>
to end position <b>q_end</b>
under given <b>kinematical constraints</b>. The positions can be translational or
rotational definitions (i.e., q_begin/q_end is given). In robotics such a movement is called <b>PTP</b> (Point-To-Point).
This source block generates the <b>position</b> q(t), the
<b>speed</b> qd(t) = der(q), and the <b>acceleration</b> qdd = der(qd)
as output. The signals are constructed in such a way that it is not possible
to move faster, given the <b>maximally</b> allowed <b>velocity</b> qd_max and
the <b>maximally</b> allowed <b>acceleration</b> qdd_max:
</p>

<p>
<img src=\"modelica://Modelica/Resources/Images/Blocks/Sources/KinematicPTP2.png\"
     alt=\"KinematicPTP2.png\">
</p>

<p>
If vectors q_begin/q_end have more than 1 element,
the output vectors are constructed such that all signals
are in the same periods in the acceleration, constant velocity
and deceleration phase. This means that only one of the signals
is at its limits whereas the others are synchronized in such a way
that the end point is reached at the same time instant.
</p>

<p>
This element is useful to generate a reference signal for a controller
which controls, e.g., a drive train, or to drive
a flange according to a given acceleration.
</p>

</html>", revisions = "<html>
<ul>
<li><i>March 24, 2007</i>
       by <a href=\"http://www.robotic.dlr.de/Martin.Otter/\">Martin Otter</a>:<br>
       Non-standard Modelica function \"constrain(..)\" replaced by standard
       Modelica implementation (via internal function position()).<br>
       New output signal \"moving\" added.</li>
<li><i>June 27, 2001</i>
       by Bernhard Bachmann.<br>
       Bug fixed that element is also correct if startTime is not zero.</li>
<li><i>Nov. 3, 1999</i>
       by <a href=\"http://www.robotic.dlr.de/Martin.Otter/\">Martin Otter</a>:<br>
       Vectorized and moved from Rotational to Blocks.Sources.</li>
<li><i>June 29, 1999</i>
       by <a href=\"http://www.robotic.dlr.de/Martin.Otter/\">Martin Otter</a>:<br>
       realized.</li>
</ul>
</html>"), Diagram(coordinateSystem(extent = {{-100, -100}, {100, 100}}, preserveAspectRatio = true, initialScale = 0.1, grid = {2, 2})));
end signalgen;