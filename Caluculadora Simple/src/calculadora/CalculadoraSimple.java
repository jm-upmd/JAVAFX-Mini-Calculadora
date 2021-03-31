package calculadora;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculadoraSimple extends Application {
	Label resLabel;
	TextField xField;
	TextField yField;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// layout para meter el valor de x
		xField = new TextField("0");
		HBox numxPanel = new HBox(new Label(" x = "),xField);
		// permite que se expanda horizontalmente
		HBox.setHgrow(xField, Priority.ALWAYS);
		
		// layout para recoger el valor de y 
		yField = new TextField("0");	
		HBox numyPanel = new HBox(new Label(" y = "),yField);
		HBox.setHgrow(yField, Priority.ALWAYS);
		
	
		
		// Cramos los botones para los botones
		
		Button sumaButton = new Button("+");
		// Anchura por defecto (o preferida)
		sumaButton.setPrefWidth(100);
		// Anchura máxima infinita
		sumaButton.setMaxWidth(Double.POSITIVE_INFINITY);
		HBox.setHgrow(sumaButton, Priority.ALWAYS); 
		sumaButton.setOnAction(e-> hazOperacion('+'));
		
		
		Button restaButton = new Button("-");
		restaButton.setPrefWidth(100);
		restaButton.setMaxWidth(Double.POSITIVE_INFINITY);
		HBox.setHgrow(restaButton, Priority.ALWAYS);
		restaButton.setOnAction(e-> hazOperacion('-'));

		Button prodtaButton = new Button("*");
		prodtaButton.setPrefWidth(100);
		prodtaButton.setMaxWidth(Double.POSITIVE_INFINITY);
		HBox.setHgrow(prodtaButton, Priority.ALWAYS);
		prodtaButton.setOnAction(e->hazOperacion('*'));
		
		Button divButton = new Button("/");
		divButton.setPrefWidth(100);
		divButton.setMaxWidth(Double.POSITIVE_INFINITY);
		HBox.setHgrow(divButton, Priority.ALWAYS);
		divButton.setOnAction(e-> hazOperacion('/'));
		
		HBox botonesPanel = new HBox(sumaButton,restaButton,prodtaButton,divButton);
		
		// Etiqueta para mostrar el resultado
		resLabel = new Label("x + y = 0");
		resLabel.setAlignment(Pos.CENTER);
		resLabel.setMaxWidth(Double.POSITIVE_INFINITY);
		resLabel.setMaxHeight(Double.POSITIVE_INFINITY);
        resLabel.setTextFill(Color.RED);
        resLabel.setFont(new Font(24.0));
        resLabel.setStyle("-fx-font-weight:bold");
		//Permite expandirse horizontalmente
		HBox.setHgrow(resLabel, Priority.ALWAYS);
		// Permite expandirse verticalmente.
		VBox.setVgrow(resLabel, Priority.ALWAYS);
		
		// Panel contenedor de los anteriores. Deja un espacio de 20 entre
		// sus nodos hijos y un espacio de 8 respecto a su contendor.
		VBox root = new VBox(numxPanel,numyPanel,botonesPanel,resLabel);
		root.setSpacing(20);
		root.setPadding( new Insets( 8,8,8,8 ) );
		// Aplica estilo a la fuente utiizando css
        root.setStyle("-fx-border-color:black; -fx-border-width:2px");
        
		// Creamos la escena conteniendo el panel vertical
		Scene scene = new Scene(root,400,250);        
		
		// Asinga la escena a la ventana de la aplicación
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Mini Calculadora");
		
		// Hace que la ventana no se pueda redimensionar.
		primaryStage.setResizable(false);
		
		primaryStage.show();
			
	}
	
	private void hazOperacion(char op) {
		int yValor, xValor;
		try {
			 xValor = Integer.parseInt(xField.getText());
			 yValor = Integer.parseInt(yField.getText());
		} catch (NumberFormatException e) {
			resLabel.setText("x e y deben ser números enteros");
			return;
		}
	
		int resultado=0;
		String operString = "x " + op + " y = ";
		switch (op) {
		case '+':
			resultado = xValor + yValor;
			break;
		case '-':
			resultado = xValor - yValor;
			break;
		case '*':
			resultado = xValor * yValor;
			break;
		case '/':
			if(yValor == 0) {
				resLabel.setText("Error: División por cero");
				return;
			}
			resultado = xValor / yValor;
			break;
		default:
			System.err.println("Operación no permitida");
		}
		
		resLabel.setText(operString + resultado);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
