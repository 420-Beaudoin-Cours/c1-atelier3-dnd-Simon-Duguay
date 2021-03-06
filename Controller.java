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


    public void txfSourceEx1DragDetected(MouseEvent mouseEvent) {
        if (!txfSourceEx1.getText().isEmpty()) {
            Dragboard db = txfSourceEx1.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();

            content.putString(txfSourceEx1.getText());
            db.setContent(content);
        }
    }

    public void imgBinDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void imgBinDragDropped(DragEvent dragEvent) {
        TextField source = (TextField) dragEvent.getGestureSource();

        source.clear();
        dragEvent.getDragboard().clear();
    }

    // EXERCICE 2

    public TextField txfSourceEx2;
    public ComboBox<String> cmbTarget;


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


    //EXERCICE 3

    public ImageView imgBin2;
    public TextField txfSource4Ex3;
    public TextField txfSource3Ex3;
    public TextField txfSource2Ex3;
    public TextField txfSource1Ex3;

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



    //EXERCICE 4

    public TextField txfSource1Ex4;
    public TextField txfSource2Ex4;
    public TextField txfSource3Ex4;

    public void txfDragDetected(MouseEvent mouseEvent) {
        TextField source = (TextField) mouseEvent.getSource();

        if (!source.getText().isEmpty()){
            Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText());
            db.setContent(content);
        }
    }

    public void txfDragOver(DragEvent dragEvent) {
        TextField source = (TextField) dragEvent.getGestureSource();
        TextField target = (TextField) dragEvent.getGestureTarget();

        if (source != target){
            dragEvent.acceptTransferModes(TransferMode.MOVE);
        }
    }

    public void txfDragDropped(DragEvent dragEvent) {
        TextField source = (TextField) dragEvent.getSource();
        TextField target = (TextField) dragEvent.getGestureTarget();
        Dragboard db = dragEvent.getDragboard();

        target.setText(db.getString());
        db.clear();
    }
}
