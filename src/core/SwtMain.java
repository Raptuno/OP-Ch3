package core;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

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
		shlConversorDeNmeros = new Shell();
		shlConversorDeNmeros.setSize(450, 300);
		shlConversorDeNmeros.setText("Conversor de N\u00FAmeros");
		shlConversorDeNmeros.setLayout(new FormLayout());
		
		txtNmeroAConvertir = new Text(shlConversorDeNmeros, SWT.BORDER);
		FormData fd_txtNmeroAConvertir = new FormData();
		fd_txtNmeroAConvertir.top = new FormAttachment(0, 10);
		fd_txtNmeroAConvertir.left = new FormAttachment(0, 10);
		txtNmeroAConvertir.setLayoutData(fd_txtNmeroAConvertir);
		
		Group grpConversin = new Group(shlConversorDeNmeros, SWT.NONE);
		grpConversin.setText("Conversi\u00F3n");
		grpConversin.setLayout(new GridLayout(1, false));
		FormData fd_grpConversin = new FormData();
		fd_grpConversin.top = new FormAttachment(txtNmeroAConvertir, 0, SWT.TOP);
		fd_grpConversin.left = new FormAttachment(txtNmeroAConvertir, 6);
		grpConversin.setLayoutData(fd_grpConversin);
		
		Button btnDecimalABinario = new Button(grpConversin, SWT.RADIO);
		btnDecimalABinario.setText("Decimal a binario");
		
		Button btnDecimalAOctal = new Button(grpConversin, SWT.RADIO);
		btnDecimalAOctal.setText("Decimal a octal");
		
		Button btnBinarioADecimal = new Button(grpConversin, SWT.RADIO);
		btnBinarioADecimal.setText("Binario a decimal");
		
		Button btnOctalADecimal = new Button(grpConversin, SWT.RADIO);
		btnOctalADecimal.setText("Octal a decimal");
		
		Button btnHexadecimalADecimal = new Button(grpConversin, SWT.RADIO);
		btnHexadecimalADecimal.setText("Hexadecimal a Decimal");

	}
}
