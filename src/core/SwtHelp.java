package core;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Composite;

public class SwtHelp extends Dialog {

	String[] urls;
	int index;
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
		
		shlAyuda.setSize(489, 354);
		shlAyuda.setText("Ayuda");
		shlAyuda.setLayout(new FormLayout());
		
		Browser browser = new Browser(shlAyuda, SWT.CHROMIUM);
		browser.setJavascriptEnabled(false);
		browser.setUrl(getClass().getClassLoader().getResource("html/help.html").toString());
		FormData fd_browser = new FormData();
		fd_browser.bottom = new FormAttachment(0, 315);
		fd_browser.right = new FormAttachment(0, 473);
		fd_browser.top = new FormAttachment(0, 10);
		fd_browser.left = new FormAttachment(0, 10);
		browser.setLayoutData(fd_browser);
	}
}
