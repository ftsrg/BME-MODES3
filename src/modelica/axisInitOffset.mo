model axisInitOffset
  import Cv = Modelica.SIunits.Conversions;
  import SI = Modelica.SIunits;
  parameter SI.Angle offsetDeg = 0;
  final SI.Angle offsetRad = Cv.from_deg(offsetDeg);
  Modelica.Mechanics.Rotational.Interfaces.Flange_a flange_aIN annotation(Placement(visible = true, transformation(origin = {-99, -1}, extent = {{-23, -23}, {23, 23}}, rotation = 0), iconTransformation(origin = {-100, 2}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
  Modelica.Mechanics.Rotational.Interfaces.Flange_b flange_aOUT annotation(Placement(visible = true, transformation(origin = {100, 1.77636e-15}, extent = {{-24, -24}, {24, 24}}, rotation = 0), iconTransformation(origin = {98, 2}, extent = {{-10, -10}, {10, 10}}, rotation = 0)));
equation
  flange_aOUT.phi = flange_aIN.phi + offsetRad;
  flange_aOUT.tau = -flange_aIN.tau;
  annotation(Diagram(coordinateSystem(extent = {{-100, -100}, {100, 100}}, preserveAspectRatio = true, initialScale = 0.1, grid = {2, 2})), Icon(coordinateSystem(extent = {{-100, -100}, {100, 100}}, preserveAspectRatio = true, initialScale = 0.1, grid = {2, 2}), graphics = {Rectangle(origin = {-1, -2}, fillColor = {126, 212, 238}, fillPattern = FillPattern.Solid, extent = {{-99, 102}, {101, -98}}), Text(origin = {-69, 3}, extent = {{-33, 9}, {33, -9}}, textString = "IN"), Text(origin = {-50, 62}, extent = {{-2, 20}, {98, -32}}, textString = "Offset [Deg]:"), Text(origin = {-48, 8}, extent = {{-2, 20}, {96, -36}}, textString = "%offsetDeg"), Text(origin = {70, 0}, extent = {{-14, 16}, {14, -16}}, textString = "OUT")}));
end axisInitOffset;