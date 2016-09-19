model PathToAxisControlBus "Map path planning to one axis control bus"
  extends Modelica.Blocks.Icons.Block;
  parameter Integer nAxis = 3 "Number of driven axis";
  parameter Integer axisUsed = 1 "Map path planning of axisUsed to axisControlBus";
  Modelica.Blocks.Interfaces.RealInput q annotation(Placement(transformation(extent = {{-140, 60}, {-100, 100}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealInput qd annotation(Placement(transformation(extent = {{-140, 10}, {-100, 50}}, rotation = 0)));
  Modelica.Blocks.Interfaces.RealInput qdd annotation(Placement(transformation(extent = {{-140, -50}, {-100, -10}}, rotation = 0)));
  Modelica.Mechanics.MultiBody.Examples.Systems.RobotR3.Components.AxisControlBus axisControlBus annotation(Placement(transformation(origin = {100, 0}, extent = {{-20, -20}, {20, 20}}, rotation = 270)));
  Modelica.Blocks.Routing.RealPassThrough q_axisUsed annotation(Placement(transformation(extent = {{-40, 50}, {-20, 70}}, rotation = 0)));
  Modelica.Blocks.Routing.RealPassThrough qd_axisUsed annotation(Placement(transformation(extent = {{-40, 10}, {-20, 30}}, rotation = 0)));
  Modelica.Blocks.Routing.RealPassThrough qdd_axisUsed annotation(Placement(transformation(extent = {{-40, -30}, {-20, -10}}, rotation = 0)));
  Modelica.Blocks.Interfaces.BooleanInput moving annotation(Placement(transformation(extent = {{-140, -100}, {-100, -60}}, rotation = 0)));
  Modelica.Blocks.Routing.BooleanPassThrough motion_ref_axisUsed annotation(Placement(transformation(extent = {{-40, -70}, {-20, -50}}, rotation = 0)));
equation
  connect(q_axisUsed.u, q) annotation(Line(points = {{-42, 60}, {-60, 60}, {-60, 80}, {-120, 80}}, color = {0, 0, 127}));
  connect(qd_axisUsed.u, qd) annotation(Line(points = {{-42, 20}, {-80, 20}, {-80, 30}, {-120, 30}}, color = {0, 0, 127}));
  connect(qdd_axisUsed.u, qdd) annotation(Line(points = {{-42, -20}, {-80, -20}, {-80, -30}, {-120, -30}}, color = {0, 0, 127}));
  connect(motion_ref_axisUsed.u, moving) annotation(Line(points = {{-42, -60}, {-60, -60}, {-60, -80}, {-120, -80}}, color = {255, 0, 255}));
  connect(motion_ref_axisUsed.y, axisControlBus.motion_ref) annotation(Text(string = "%second", index = 1, extent = [6, 3; 6, 3]), Line(points = {{-19, -60}, {44, -60}, {44, -8}, {102, -8}, {102, 0}, {100, 0}}, color = {255, 0, 255}));
  connect(qdd_axisUsed.y, axisControlBus.acceleration_ref) annotation(Text(string = "%second", index = 1, extent = [6, 3; 6, 3]), Line(points = {{-19, -20}, {40, -20}, {40, -4}, {98, -4}, {98, 0}, {100, 0}}, color = {0, 0, 127}));
  connect(qd_axisUsed.y, axisControlBus.speed_ref) annotation(Text(string = "%second", index = 1, extent = [6, 3; 6, 3]), Line(points = {{-19, 20}, {20, 20}, {20, 0}, {100, 0}}, color = {0, 0, 127}));
  connect(q_axisUsed.y, axisControlBus.angle_ref) annotation(Text(string = "%second", index = 1, extent = [6, 3; 6, 3]), Line(points = {{-19, 60}, {40, 60}, {40, 4}, {96, 4}}, color = {0, 0, 127}));
  annotation(defaultComponentName = "pathToAxis1", Icon(coordinateSystem(preserveAspectRatio = true, extent = {{-100, -100}, {100, 100}}, initialScale = 0.1), graphics = {Text(extent = {{-100, 98}, {-24, 68}}, lineColor = {0, 0, 0}, textString = "q"), Text(extent = {{-94, 46}, {-18, 16}}, lineColor = {0, 0, 0}, textString = "qd"), Text(extent = {{-96, -16}, {-20, -46}}, lineColor = {0, 0, 0}, textString = "qdd"), Text(extent = {{-2, 20}, {80, -18}}, lineColor = {0, 0, 0}, textString = "%axisUsed"), Text(extent = {{2, 52}, {76, 28}}, lineColor = {0, 0, 0}, textString = "axis"), Text(extent = {{-94, -70}, {32, -96}}, lineColor = {0, 0, 0}, textString = "moving")}));
end PathToAxisControlBus;