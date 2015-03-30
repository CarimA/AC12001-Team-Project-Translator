import org.eclipse.swt.widgets.Display;


public class Program {
	public static Display display;
	
	public static WindowAddRemove ui_arw; 
	public static WindowDictionary ui_dct;
	public static WindowBrowse ui_brw;
	public static WindowDisplay ui_dsp;
	
	public static void main(String[] args)
    {
		// must be called first, do not change.
		display = Display.getDefault();
		
    	//Tester c = new Tester();
		ui_dct = new WindowDictionary(display);
    }
}
