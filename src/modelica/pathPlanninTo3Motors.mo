block pathPlanninTo3Motors
  extends Modelica.Blocks.Icons.Block;
  import SI = Modelica.SIunits;
  import Cv = Modelica.SIunits.Conversions;
  parameter Integer StepNumber = 5;
  parameter Real q_begin = 0;
  parameter Real q_all[:] = {30} "All position";
  parameter Real qd_max = 10 "Maximum velocities der(q)";
  parameter Real qdd_max = 100 "Maximum accelerations der(qd)";
  final parameter Integer nStep = size(q_all, 1);
  Real control[nStep];
  Real controls;
  Integer whathappening;
  Boolean endcondition;
  Boolean endconditionFirstPart;
  Real p_q_all[nStep] = if size(q_all, 1) == 1 then ones(nStep) * q_all[1] else q_all;
  constant Real eps = 0.01;
  Modelica.Blocks.Interfaces.IntegerInput index annotation(Placement(visible = false, transformation(extent = {{-170, 86}, {-130, 126}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput qdd "Reference acceleration of path planning" annotation(Placement(visible = true, transformation(extent = {{100, -42}, {120, -22}}, rotation = 0), iconTransformation(extent = {{100, -40}, {120, -20}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput qd "Reference speed of path planning" annotation(Placement(visible = true, transformation(extent = {{100, 18}, {120, 38}}, rotation = 0), iconTransformation(extent = {{100, 20}, {120, 40}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput q "Reference position of path planning" annotation(Placement(visible = true, transformation(extent = {{100, 68}, {120, 88}}, rotation = 0), iconTransformation(extent = {{100, 70}, {120, 90}}, rotation = 0)));
  Modelica.Blocks.Interfaces.BooleanOutput moving "= true, if end position not yet reached; = false, if end position reached or axis is completely at rest" annotation(Placement(visible = true, transformation(extent = {{100, -92}, {120, -72}}, rotation = 0), iconTransformation(extent = {{100, -90}, {120, -70}}, rotation = 0)));
  stategraph doboz1(qd_max = qd_max, qdd_max = qdd_max, begin = q_begin) annotation(Placement(visible = true, transformation(origin = {11, 29}, extent = {{-11, -11}, {11, 11}}, rotation = 0)));
  Modelica.StateGraph.Interfaces.Step_in step_in1 annotation(Placement(visible = true, transformation(origin = {-102, 29}, extent = {{-10, -10}, {10, 10}}, rotation = 0), iconTransformation(origin = {-100, 40}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition2(condition = true) annotation(Placement(visible = true, transformation(origin = {36, -40}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.StateGraph.TransitionWithSignal transitionWithSignal1 annotation(Placement(visible = true, transformation(origin = {-30, -40}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.Blocks.Logical.Timer timer1 annotation(Placement(visible = true, transformation(origin = {-4, -66}, extent = {{6, -6}, {-6, 6}}, rotation = 0)));
  Modelica.Blocks.Logical.GreaterEqualThreshold greaterEqualThreshold1(threshold = 0.001) annotation(Placement(visible = true, transformation(origin = {-20, -66}, extent = {{6, -6}, {-6, 6}}, rotation = 0)));
  Modelica.StateGraph.Step step1 annotation(Placement(visible = true, transformation(origin = {-66, -40}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
  Modelica.StateGraph.Interfaces.Step_out step_out1 annotation(Placement(visible = true, transformation(origin = {-96, -40}, extent = {{-10, -10}, {10, 10}}, rotation = 0), iconTransformation(origin = {-100, -24}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.StepWithSignal StepWithSignal1 annotation(Placement(visible = true, transformation(origin = {10, -40}, extent = {{10, -10}, {-10, 10}}, rotation = 0)));
initial equation
  endcondition = false;
  endconditionFirstPart = false;
equation
  connect(StepWithSignal1.inPort[1], transition2.outPort) annotation(Line(points = {{21, -40}, {34.5, -40}}));
  connect(StepWithSignal1.outPort[1], transitionWithSignal1.inPort) annotation(Line(points = {{-0.5, -40}, {-25.5, -40}}));
  connect(StepWithSignal1.active, timer1.u) annotation(Line(points = {{10, -51}, {10, -59.5}, {10, -59.5}, {10, -66}, {6.5, -66}, {6.5, -66}, {3, -66}}, color = {255, 0, 255}));
  connect(step1.outPort[1], step_out1) annotation(Line(points = {{-76.5, -40}, {-96, -40}}));
  connect(transitionWithSignal1.outPort, step1.inPort[1]) annotation(Line(points = {{-31.5, -40}, {-55, -40}}));
  connect(timer1.y, greaterEqualThreshold1.u) annotation(Line(points = {{-10.6, -66}, {-12.6, -66}}, color = {0, 0, 127}));
  connect(greaterEqualThreshold1.y, transitionWithSignal1.condition) annotation(Line(points = {{-26.6, -66}, {-28.1, -66}, {-28.1, -66}, {-29.6, -66}, {-29.6, -59}, {-29.6, -59}, {-29.6, -56.5}, {-29.6, -56.5}, {-29.6, -52}}, color = {255, 0, 255}));
  connect(doboz1.outPort, transition2.inPort) annotation(Line(points = {{22, 29}, {46, 29}, {46, -40}, {40, -40}}));
  connect(doboz1.q, q) annotation(Line(points = {{22, 37}, {74, 37}, {74, 77.6}, {110, 77.6}}, color = {0, 0, 127}));
  connect(doboz1.qd, qd) annotation(Line(points = {{22, 32}, {80, 32}, {80, 27.6}, {110, 27.6}}, color = {0, 0, 127}));
  connect(step_in1, doboz1.inPort) annotation(Line(points = {{-102, 29}, {0, 29}}));
  connect(doboz1.qdd, qdd) annotation(Line(points = {{22, 25}, {74, 25}, {74, -32.4}, {110, -32.4}}, color = {0, 0, 127}));
  connect(doboz1.moving, moving) annotation(Line(points = {{22, 20}, {66, 20}, {66, -81.8}, {110, -81.8}}, color = {255, 0, 255}));
  connect(doboz1.controls, controls);
  when q + eps > controls and q - eps < controls and index == StepNumber then
    endconditionFirstPart = true;
  end when;
  when endconditionFirstPart and step1.active then
    endcondition = true;
  end when;
  for i in 1:nStep loop
    if i == index then
      control[i] = 1;
    else
      control[i] = 0;
    end if;
  end for;
  if StepWithSignal1.active then
    whathappening = 10;
  else
    whathappening = doboz1.whathappening;
  end if;
  controls = control * p_q_all;
  annotation(defaultComponentName = "signalgen", Diagram(coordinateSystem(extent = {{-100, -100}, {100, 100}}, preserveAspectRatio = true, initialScale = 0.1, grid = {2, 2})), Icon(coordinateSystem(extent = {{-100, -100}, {100, 100}}, preserveAspectRatio = true, initialScale = 0.1, grid = {2, 2}), graphics = {Line(points = {{-80, 78}, {-80, -82}}, color = {192, 192, 192}), Polygon(lineColor = {192, 192, 192}, fillColor = {192, 192, 192}, fillPattern = FillPattern.Solid, points = {{-80, 90}, {-88, 68}, {-72, 68}, {-80, 88}, {-80, 90}}), Line(points = {{-90, 0}, {17, 0}}, color = {192, 192, 192}), Line(points = {{-80, 0}, {-70, 0}, {-70, 70}, {-50, 70}, {-50, 0}, {-15, 0}, {-15, -70}, {5, -70}, {5, 0}, {18, 0}}), Text(extent = {{34, 96}, {94, 66}}, textString = "q"), Text(extent = {{40, 44}, {96, 14}}, textString = "qd"), Text(extent = {{32, -18}, {99, -44}}, textString = "qdd"), Text(extent = {{-32, -74}, {97, -96}}, textString = "moving")}));
end pathPlanninTo3Motors;