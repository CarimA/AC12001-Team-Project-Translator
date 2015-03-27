import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;


public class AddRemoveWindow extends Composite {
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AddRemoveWindow(Composite parent, int style) {
		super(parent, style);
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setBounds(215, 37, 75, 25);
		btnCancel.setText("Cancel");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 10, 280, 21);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 37, 75, 25);
		btnNewButton.setText("Add");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setBounds(114, 37, 75, 25);
		btnNewButton_1.setText("Remove");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
