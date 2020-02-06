package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import org.w3c.dom.Text;

public class Controller {

    // EXERCICE 1

    public TextField txfSourceEx1;
    public ImageView imgBin;
    public TextField txfSourceEx2;
    public ComboBox<String> cmbTarget;
    public ImageView imgBin2;

    // EXERCICE 2
    public TextField txfSource4Ex3;
    public TextField txfSource3Ex3;
    public TextField txfSource2Ex3;
    public TextField txfSource1Ex3;

    public void txfSourceEx1DragDetected(MouseEvent mouseEvent) {
        if (!txfSourceEx1.getText().isEmpty()) {
            Dragboard db = txfSourceEx1.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(txfSourceEx1.getText());
            db.setContent(content);
        }
    }


    //EXERCICE 3

    public void imgBinDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void imgBinDragDropped(DragEvent dragEvent) {
        TextField source = (TextField) dragEvent.getGestureSource();
        source.clear();
        dragEvent.getDragboard().clear();
    }

    public void txfSourceEx2DragDetected(MouseEvent mouseEvent) {
        if (!txfSourceEx2.getText().isEmpty()) {
            Dragboard db = txfSourceEx2.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(txfSourceEx2.getText());
            db.setContent(content);
        }
    }

    public void cmbTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void cmbTargetDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        cmbTarget.getItems().add(db.getString());
        cmbTarget.getSelectionModel().selectLast();
        db.clear();
    }

    public void txfSourceEx3DragDetected(MouseEvent mouseEvent) {
        TextField source = (TextField) mouseEvent.getSource();
        if (!source.getText().isEmpty()) {
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText());
            db.setContent(content);
        }
    }

    public void imgBin2DragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void imgBin2DragDropped(DragEvent dragEvent) {
        TextField source = (TextField) dragEvent.getGestureSource();
        dragEvent.getDragboard().clear();
        source.clear();
    }


}
