package core;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

public class SwtHelp extends Dialog {

	protected Object result;
	protected Shell shlAyuda;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SwtHelp(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlAyuda.open();
		shlAyuda.layout();
		Display display = getParent().getDisplay();
		while (!shlAyuda.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlAyuda = new Shell(getParent(), SWT.DIALOG_TRIM);
		shlAyuda.setSize(450, 300);
		shlAyuda.setText("Ayuda");

	}

}
