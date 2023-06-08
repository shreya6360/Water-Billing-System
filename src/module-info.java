module water_billing {
	requires javafx.controls;
	requires javafx.base;
	requires java.sql;
	requires javafx.graphics;
	opens application to javafx.graphics, javafx.fxml;
}
