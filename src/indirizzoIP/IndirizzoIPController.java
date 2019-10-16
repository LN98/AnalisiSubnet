package indirizzoIP;

	/**
	 * Sample Skeleton for 'IndirizziIp.fxml' Controller Class
	 */
	import java.net.URL;
import java.util.ResourceBundle;

import indirizzoIP.model.IndirizzoIP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

	public class IndirizzoIPController {

		IndirizzoIP ip;
	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="txtPByte"
	    private TextArea txtPByte; // Value injected by FXMLLoader

	    @FXML // fx:id="txtSByte"
	    private TextArea txtSByte; // Value injected by FXMLLoader

	    @FXML // fx:id="txtTByte"
	    private TextArea txtTByte; // Value injected by FXMLLoader

	    @FXML // fx:id="txtQByte"
	    private TextArea txtQByte; // Value injected by FXMLLoader

	    @FXML // fx:id="txtCIDR"
	    private TextArea txtCIDR; // Value injected by FXMLLoader

	    @FXML // fx:id="btbAnalisi"
	    private Button btnAnalisi; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="txtAnalisi"
	    private TextArea txtAnalisi; // Value injected by FXMLLoader

	    @FXML
	    void doAnalisi(ActionEvent event) {
	    	
	    	ip.setIndirizzoIP(Integer.parseInt(txtPByte.getText()), Integer.parseInt(txtSByte.getText()),Integer.parseInt(txtTByte.getText()),Integer.parseInt(txtQByte.getText()),Integer.parseInt(txtCIDR.getText()));
	    	txtAnalisi.setText(ip.toString());
			

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	    	
	        assert txtPByte != null : "fx:id=\"txtPByte\" was not injected: check your FXML file 'IndirizziIp.fxml'.";
	        assert txtSByte != null : "fx:id=\"txtSByte\" was not injected: check your FXML file 'IndirizziIp.fxml'.";
	        assert txtTByte != null : "fx:id=\"txtTByte\" was not injected: check your FXML file 'IndirizziIp.fxml'.";
	        assert txtQByte != null : "fx:id=\"txtQByte\" was not injected: check your FXML file 'IndirizziIp.fxml'.";
	        assert txtCIDR != null : "fx:id=\"txtCIDR\" was not injected: check your FXML file 'IndirizziIp.fxml'.";
	        assert btnAnalisi != null : "fx:id=\"btbAnalisi\" was not injected: check your FXML file 'IndirizziIp.fxml'.";
	        assert txtAnalisi != null : "fx:id=\"txtAnalisi\" was not injected: check your FXML file 'IndirizziIp.fxml'.";

	    }
	
}
