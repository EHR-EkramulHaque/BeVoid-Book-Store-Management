import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.text.*;

class TextPrompt extends JLabel implements FocusListener, DocumentListener {
  JTextComponent component;
  Document document;

  public TextPrompt(String text, JTextComponent component) {
    this.component = component;
    document = component.getDocument();

    setText(text);
    setFont(component.getFont());
    setBorder(new EmptyBorder(component.getInsets()));

    component.addFocusListener(this);
    document.addDocumentListener(this);

    component.add(this);
  }

  public void checkForPrompt() {
    if (document.getLength() == 0)
      setSize(component.getSize());
    else
      setSize(0, 0);
  }

  public void focusGained(FocusEvent e) {
    checkForPrompt();
  }

  public void focusLost(FocusEvent e) {
    setSize(0, 0);
  }


  public void insertUpdate(DocumentEvent e) {
    checkForPrompt();
  }

  public void removeUpdate(DocumentEvent e) {
    checkForPrompt();
  }

  public void changedUpdate(DocumentEvent e) {
  }

}