package core;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Text;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.*;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class SwtMain {

	Clipboard cb=new Clipboard(Display.getDefault());
	protected Shell shlConversorDeNmeros;
	SwtHelp swth;
	private Text txtInput;
	private Text txtRes;
	
	public void helpListener() {
		swth.open();
	}

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
		shlConversorDeNmeros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				helpListener();
			}
		});
		shlConversorDeNmeros.setSize(354, 199);
		shlConversorDeNmeros.setText("Conversor de N\u00FAmeros");
		shlConversorDeNmeros.setLayout(new FormLayout());
		
		swth=new SwtHelp(shlConversorDeNmeros, 0);
		
		Group grpConversin = new Group(shlConversorDeNmeros, SWT.NONE);
		grpConversin.setText("Conversi\u00F3n");
		grpConversin.setLayout(new GridLayout(1, false));
		FormData fd_grpConversin = new FormData();
		fd_grpConversin.top = new FormAttachment(0, 10);
		fd_grpConversin.left = new FormAttachment(0, 10);
		grpConversin.setLayoutData(fd_grpConversin);
		
		Button btnDecToBin = new Button(grpConversin, SWT.RADIO);
		btnDecToBin.setSelection(true);
		btnDecToBin.setText("Decimal a binario");
		
		Button btnDecToOct = new Button(grpConversin, SWT.RADIO);
		btnDecToOct.setText("Decimal a octal");
		
		Button btnBinToDec = new Button(grpConversin, SWT.RADIO);
		btnBinToDec.setText("Binario a decimal");
		
		Button btnOctToDec = new Button(grpConversin, SWT.RADIO);
		btnOctToDec.setText("Octal a decimal");
		
		Button btnHexToDec = new Button(grpConversin, SWT.RADIO);
		btnHexToDec.setText("Hexadecimal a Decimal");
		
		Group grpNmeros = new Group(shlConversorDeNmeros, SWT.NONE);
		grpNmeros.setText("N\u00FAmeros");
		grpNmeros.setLayout(new GridLayout(2, false));
		FormData fd_grpNmeros = new FormData();
		fd_grpNmeros.top = new FormAttachment(grpConversin, 0, SWT.TOP);
		fd_grpNmeros.left = new FormAttachment(grpConversin, 6);
		grpNmeros.setLayoutData(fd_grpNmeros);
		
		Label lblEntrada = new Label(grpNmeros, SWT.NONE);
		lblEntrada.setText("Entrada:");
		
		txtInput = new Text(grpNmeros, SWT.BORDER);
		
		Label lblResultado = new Label(grpNmeros, SWT.NONE);
		lblResultado.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblResultado.setText("Resultado: ");
		
		txtRes = new Text(grpNmeros, SWT.NONE);
		txtRes.setEnabled(false);
		txtRes.setEditable(false);
		txtRes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite cmpCbBtns = new Composite(grpNmeros, SWT.NONE);
		cmpCbBtns.setLayout(new GridLayout(1, false));
		
		Button btnCopiar = new Button(cmpCbBtns, SWT.NONE);
		btnCopiar.setEnabled(false);
		btnCopiar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String copy=txtRes.getText();
				TextTransfer tt=TextTransfer.getInstance();
				if(!txtRes.getText().isEmpty()) {
					cb.setContents(new Object[] {copy}, new Transfer[] {tt});
				}
			}
		});
		btnCopiar.setText("Copiar");
		new Label(grpNmeros, SWT.NONE);
		
		Composite cmpBotones = new Composite(shlConversorDeNmeros, SWT.NONE);
		cmpBotones.setLayout(new GridLayout(3, false));
		FormData fd_cmpBotones = new FormData();
		fd_cmpBotones.top = new FormAttachment(grpNmeros, 6);
		fd_cmpBotones.left = new FormAttachment(grpConversin, 6);
		cmpBotones.setLayoutData(fd_cmpBotones);
		
		Button btnConvertir = new Button(cmpBotones, SWT.NONE);
		btnConvertir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Control c[]=grpConversin.getChildren();
				Button b;
				
				for(int i=0; i<c.length; i++) {
					b=(Button)c[i];
					
					if(b.getSelection()) {
						switch(b.getText().toLowerCase()) { //Inicio del Switch-case
						case "decimal a binario":
							if(txtInput.getText().matches("[0-9]+")) {
								converter.DecToBin(txtInput.getText());
								txtRes.setText(converter.getOutput());
							} else {
								JOptionPane.showMessageDialog(null, "Error: Sólo se admiten letras de la A a la F en conversion Hexadecimal a Decimal");
							}
							break;
						} //Fin del Switch-case
					}
				}
				if(!btnCopiar.isEnabled()) {
					btnCopiar.setEnabled(true);
				}
			}
		});
		btnConvertir.setText("Convertir");
		
		Button btnAyuda = new Button(cmpBotones, SWT.NONE);
		btnAyuda.setEnabled(false);
		btnAyuda.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				helpListener();
			}
		});
		btnAyuda.setText("Ayuda");
		
		Button btnSalir = new Button(cmpBotones, SWT.NONE);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Runtime.getRuntime().exit(0);
			}
		});
		btnSalir.setText("Salir");

	}
}
