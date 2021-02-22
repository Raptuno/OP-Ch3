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

public class SwtMain {

	protected Shell shell;
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());
		
		txtNmeroAConvertir = new Text(shell, SWT.BORDER);
		FormData fd_txtNmeroAConvertir = new FormData();
		fd_txtNmeroAConvertir.top = new FormAttachment(0, 10);
		fd_txtNmeroAConvertir.left = new FormAttachment(0, 10);
		txtNmeroAConvertir.setLayoutData(fd_txtNmeroAConvertir);
		
		Group grpSistemaDeEntrada = new Group(shell, SWT.NONE);
		grpSistemaDeEntrada.setText("Sistema de Entrada");
		grpSistemaDeEntrada.setLayout(new GridLayout(1, false));
		FormData fd_grpSistemaDeEntrada = new FormData();
		fd_grpSistemaDeEntrada.top = new FormAttachment(txtNmeroAConvertir, 0, SWT.TOP);
		fd_grpSistemaDeEntrada.left = new FormAttachment(txtNmeroAConvertir, 6);
		grpSistemaDeEntrada.setLayoutData(fd_grpSistemaDeEntrada);

	}
}
