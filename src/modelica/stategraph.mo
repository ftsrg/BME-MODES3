model stategraph
  parameter Real qd_max = 10;
  parameter Real qdd_max = 100;
  parameter Real begin = 0;
  Integer whathappening;
  constant Real eps = 0.000001;
  Modelica.Blocks.Interfaces.RealInput controls annotation(Placement(visible = false, transformation(extent = {{-170, 86}, {-130, 126}}, rotation = 0), iconTransformation(origin = {-133, 95}, extent = {{-17, -17}, {17, 17}}, rotation = 0)));
  Modelica.StateGraph.Step endStep(nOut = 1, nIn = 3) annotation(Placement(visible = true, transformation(origin = {80, 0}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Interfaces.Step_out outPort annotation(Placement(visible = true, transformation(origin = {106, 0}, extent = {{-10, -10}, {10, 10}}, rotation = 0), iconTransformation(origin = {104, 0}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput q "Reference position of path planning" annotation(Placement(visible = true, transformation(extent = {{98, 70}, {118, 90}}, rotation = 0), iconTransformation(extent = {{92, 66}, {112, 86}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput qd "Reference speed of path planning" annotation(Placement(visible = true, transformation(extent = {{98, 28}, {118, 48}}, rotation = 0), iconTransformation(extent = {{92, 16}, {112, 36}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealOutput qdd "Reference acceleration of path planning" annotation(Placement(visible = true, transformation(extent = {{98, -32}, {118, -12}}, rotation = 0), iconTransformation(extent = {{92, -44}, {112, -24}}, rotation = 0)));
  Modelica.Blocks.Interfaces.BooleanOutput moving "= true, if end position not yet reached; = false, if end position reached or axis is completely at rest" annotation(Placement(visible = true, transformation(extent = {{98, -90}, {118, -70}}, rotation = 0), iconTransformation(extent = {{92, -88}, {112, -68}}, rotation = 0)));
  Modelica.StateGraph.Transition transition1(condition = q + eps < controls) annotation(Placement(visible = true, transformation(origin = {-40, 70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Step accelerate_backward annotation(Placement(visible = true, transformation(origin = {-10, -70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition5(condition = qd <= (-qd_max) or q - qd * qd / 2 / qdd_max <= controls) annotation(Placement(visible = true, transformation(origin = {20, -70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Step decelerate_forward annotation(Placement(visible = true, transformation(origin = {10, 30}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Step constant_speed_backward annotation(Placement(visible = true, transformation(origin = {52, -70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition8(condition = qd >= 0) annotation(Placement(visible = true, transformation(origin = {40, -30}, extent = {{10, 10}, {-10, -10}}, rotation = 180)));
  Modelica.StateGraph.Interfaces.Step_in inPort annotation(Placement(visible = true, transformation(origin = {-104, 0}, extent = {{-10, -10}, {10, 10}}, rotation = 0), iconTransformation(origin = {-96, 0}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Step stationary(nOut = 3, nIn = 1) annotation(Placement(visible = true, transformation(origin = {-76, 0}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Step constant_speed_forward annotation(Placement(visible = true, transformation(origin = {50, 70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Step accelerate_forward(nOut = 1) annotation(Placement(visible = true, transformation(origin = {-10, 70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition4(condition = q - eps > controls) annotation(Placement(visible = true, transformation(origin = {-40, -70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition2(condition = qd >= qd_max or q + qd * qd / 2 / qdd_max >= controls) annotation(Placement(visible = true, transformation(origin = {20, 70}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Step decelerate_backward annotation(Placement(visible = true, transformation(origin = {10, -30}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition7(condition = qd <= 0) annotation(Placement(visible = true, transformation(origin = {40, 30}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition6(condition = q - qd * qd / 2 / qdd_max <= controls) annotation(Placement(visible = true, transformation(origin = {-20, -30}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition3(condition = q + qd * qd / 2 / qdd_max >= controls) annotation(Placement(visible = true, transformation(origin = {-20, 30}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.StateGraph.Transition transition9 annotation(Placement(visible = true, transformation(origin = {40, 0}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
initial equation
  q = begin;
  qd = 0;
equation
  connect(stationary.outPort[3], transition9.inPort) annotation(Line(points = {{-65.5, 0}, {36, 0}}));
  connect(transition9.outPort, endStep.inPort[3]) annotation(Line(points = {{41.5, 0}, {69, 0}}));
  connect(transition3.outPort, decelerate_forward.inPort[1]) annotation(Line(points = {{-18.5, 30}, {-1, 30}}));
  connect(constant_speed_forward.outPort[1], transition3.inPort) annotation(Line(points = {{60.5, 70}, {71.25, 70}, {71.25, 50}, {-39.375, 50}, {-39.375, 30}, {-24, 30}}));
  connect(transition6.outPort, decelerate_backward.inPort[1]) annotation(Line(points = {{-18.5, -30}, {-1, -30}}));
  connect(constant_speed_backward.outPort[1], transition6.inPort) annotation(Line(points = {{62.5, -70}, {74.25, -70}, {74.25, -50}, {-40.875, -50}, {-40.875, -30}, {-24, -30}}));
  connect(decelerate_forward.outPort[1], transition7.inPort) annotation(Line(points = {{20.5, 30}, {36, 30}}));
  connect(transition7.outPort, endStep.inPort[1]) annotation(Line(points = {{41.5, 30}, {59.5, 30}, {59.5, 0}, {69, 0}}));
  connect(decelerate_backward.outPort[1], transition8.inPort) annotation(Line(points = {{20.5, -30}, {36, -30}}));
  connect(accelerate_forward.outPort[1], transition2.inPort) annotation(Line(points = {{1, 70}, {16, 70}}));
  connect(transition2.outPort, constant_speed_forward.inPort[1]) annotation(Line(points = {{21.5, 70}, {39, 70}}));
  connect(stationary.outPort[2], transition4.inPort) annotation(Line(points = {{-65.5, 0}, {-57.75, 0}, {-57.75, -70}, {-44, -70}}));
  connect(transition4.outPort, accelerate_backward.inPort[1]) annotation(Line(points = {{-38.5, -70}, {-21, -70}}));
  connect(transition1.outPort, accelerate_forward.inPort[1]) annotation(Line(points = {{-38.5, 70}, {-21, 70}}));
  connect(inPort, stationary.inPort[1]) annotation(Line(points = {{-104, 0}, {-87, 0}}));
  connect(stationary.outPort[1], transition1.inPort) annotation(Line(points = {{-65.5, 0}, {-57.75, 0}, {-57.75, 70}, {-44, 70}}));
  connect(transition8.outPort, endStep.inPort[2]) annotation(Line(points = {{41.5, -30}, {59.5, -30}, {59.5, 0}, {69, 0}}));
  connect(transition5.outPort, constant_speed_backward.inPort[1]) annotation(Line(points = {{21.5, -70}, {41, -70}}));
  connect(accelerate_backward.outPort[1], transition5.inPort) annotation(Line(points = {{0.5, -70}, {16, -70}}));
  connect(outPort, endStep.outPort[1]) annotation(Line(points = {{106, 0}, {90.5, 0}}));
  qd = der(q);
  qdd = der(qd);
  if stationary.active then
    qdd = 0;
    whathappening = 1;
    moving = false;
  elseif endStep.active then
    qdd = 0;
    whathappening = 8;
    moving = false;
  elseif accelerate_forward.active then
    qdd = qdd_max;
    whathappening = 2;
    moving = true;
  elseif constant_speed_forward.active then
    qdd = 0;
    whathappening = 3;
    moving = true;
  elseif decelerate_forward.active then
    qdd = -qdd_max;
    whathappening = 4;
    moving = true;
  elseif accelerate_backward.active then
    qdd = -qdd_max;
    whathappening = 5;
    moving = true;
  elseif constant_speed_backward.active then
    qdd = 0;
    whathappening = 6;
    moving = true;
  elseif decelerate_backward.active then
    qdd = qdd_max;
    whathappening = 7;
    moving = true;
  else
    qdd = 0;
    whathappening = -10;
    moving = false;
  end if;
  annotation(Icon(coordinateSystem(extent = {{-100, -100}, {100, 100}}, preserveAspectRatio = true, initialScale = 0.1, grid = {2, 2})), Diagram(coordinateSystem(extent = {{-100, -100}, {100, 100}}, preserveAspectRatio = true, initialScale = 0.1, grid = {2, 2})));
end stategraph;