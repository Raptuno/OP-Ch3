package core;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Text;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SwtMain {

	protected Shell shlConversorDeNmeros;
	private Text txtNmeroAConvertir;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SwtMain window = new SwtMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlConversorDeNmeros.open();
		shlConversorDeNmeros.layout();
		while (!shlConversorDeNmeros.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		Converter converter=new Converter();
		
		shlConversorDeNmeros = new Shell();
		shlConversorDeNmeros.setSize(450, 300);
		shlConversorDeNmeros.setText("Conversor de N\u00FAmeros");
		shlConversorDeNmeros.setLayout(new FormLayout());
		
		txtNmeroAConvertir = new Text(shlConversorDeNmeros, SWT.BORDER);
		FormData fd_txtNmeroAConvertir = new FormData();
		txtNmeroAConvertir.setLayoutData(fd_txtNmeroAConvertir);
		
		Group grpConversin = new Group(shlConversorDeNmeros, SWT.NONE);
		grpConversin.setText("Conversi\u00F3n");
		grpConversin.setLayout(new GridLayout(1, false));
		FormData fd_grpConversin = new FormData();
		fd_grpConversin.top = new FormAttachment(0, 10);
		fd_grpConversin.left = new FormAttachment(0, 10);
		grpConversin.setLayoutData(fd_grpConversin);
		
		Button btnDecimalABinario = new Button(grpConversin, SWT.RADIO);
		btnDecimalABinario.setSelection(true);
		btnDecimalABinario.setText("Decimal a binario");
		
		Button btnDecimalAOctal = new Button(grpConversin, SWT.RADIO);
		btnDecimalAOctal.setText("Decimal a octal");
		
		Button btnBinarioADecimal = new Button(grpConversin, SWT.RADIO);
		btnBinarioADecimal.setText("Binario a decimal");
		
		Button btnOctalADecimal = new Button(grpConversin, SWT.RADIO);
		btnOctalADecimal.setText("Octal a decimal");
		
		Button btnHexadecimalADecimal = new Button(grpConversin, SWT.RADIO);
		btnHexadecimalADecimal.setText("Hexadecimal a Decimal");
		
		Composite cmpBotones = new Composite(shlConversorDeNmeros, SWT.NONE);
		cmpBotones.setLayout(new GridLayout(3, false));
		FormData fd_cmpBotones = new FormData();
		fd_cmpBotones.left = new FormAttachment(grpConversin, 6);
		fd_cmpBotones.bottom = new FormAttachment(grpConversin, 0, SWT.BOTTOM);
		cmpBotones.setLayoutData(fd_cmpBotones);
		
		Button btnConvertir = new Button(cmpBotones, SWT.NONE);
		btnConvertir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Control c[]=grpConversin.getChildren();
				Button b;
				
				for(int i=0; i<c.length; i++) {
					b=(Button)c[i];
					
					if(b.getSelection()&&txtNmeroAConvertir.getText().matches("[0-9]+")) {
						switch(b.getText().toLowerCase()) { //Inicio del Switch-case
						case "decimal a binario":
							converter.DecToBin(txtNmeroAConvertir.getText());
							break;
						} //Fin del Switch-case
					} else if (txtNmeroAConvertir.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Error: El cuadro de texto no debe estar vacío");
						break;
					} else if (!txtNmeroAConvertir.getText().matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "Error: Ingrese sólo números");
						break;
					}
				}
			}
		});
		btnConvertir.setText("Convertir");
		
		Button btnAyuda = new Button(cmpBotones, SWT.NONE);
		btnAyuda.setText("Ayuda");
		
		Button btnSalir = new Button(cmpBotones, SWT.NONE);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Runtime.getRuntime().exit(0);
			}
		});
		btnSalir.setText("Salir");
		
		Label lblResultado = new Label(shlConversorDeNmeros, SWT.NONE);
		FormData fd_lblResultado = new FormData();
		fd_lblResultado.top = new FormAttachment(txtNmeroAConvertir, 6);
		fd_lblResultado.left = new FormAttachment(grpConversin, 6);
		lblResultado.setLayoutData(fd_lblResultado);
		lblResultado.setText("Resultado: ");
		
		Label lblEntrada = new Label(shlConversorDeNmeros, SWT.NONE);
		fd_txtNmeroAConvertir.top = new FormAttachment(lblEntrada, -3, SWT.TOP);
		fd_txtNmeroAConvertir.left = new FormAttachment(lblEntrada, 6);
		FormData fd_lblEntrada = new FormData();
		fd_lblEntrada.top = new FormAttachment(0, 10);
		fd_lblEntrada.left = new FormAttachment(grpConversin, 6);
		lblEntrada.setLayoutData(fd_lblEntrada);
		lblEntrada.setText("Entrada:");

	}
}
