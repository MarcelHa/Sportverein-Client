package utilities;

import javafx.scene.control.*;

public class ValidationListener {

	public void addMailListener(TextField mail) {
		mail.textProperty().addListener((e) -> {
			mailListenFunc(mail);
		});
	}

	public void addQuantityListener(TextField quantity, int available) {
		quantity.textProperty().addListener((e) -> {
			quantityListenFunc(quantity, available);
		});
	}

	public void quantityListenFunc(TextField quantity, int available) {
		FieldValidation validate = new FieldValidation();
		if (quantity.getText() != null && !quantity.getText().equals("")) {
			if (validate.isQuantityNumber(quantity)) {
				if (validate.quantityCompareAvailable(quantity, available)) {
					StyleValidation.unMark(quantity);
				} else {
					StyleValidation.markRed(quantity);

				}
			} else {
				StyleValidation.markRed(quantity);
			}
		} else {
			StyleValidation.unMark(quantity);
		}
	}

	public void mailListenFunc(TextField mail) {
		FieldValidation validate = new FieldValidation();
		if (mail.getText() != null && !mail.getText().equals("") && !validate.mail(mail)) {
			StyleValidation.markRed(mail);
		} else {
			StyleValidation.unMark(mail);
		}
	}

	public void addEmptyListener(Control control) {
		if (control.getClass().equals(TextField.class)) {
			addEmptyListenerTextField((TextField) control);
		}
		if (control.getClass().equals(Slider.class)) {
			addEmptyListenerSlider((Slider) control);
		}
		if (control.getClass().equals(DatePicker.class)) {
			addEmptyListenerDatePicker((DatePicker) control);
		}
		if (control.getClass().equals(ChoiceBox.class)) {
			addEmptyListenerChoiceBox((ChoiceBox) control);
		}
	}


	public void addEmptyListenerTextField(TextField textfield) {
		textfield.textProperty().addListener((e) -> {
			if (textfield.getText() != null && !textfield.getText().equals("")) {
				StyleValidation.unMark(textfield);
			} else {
				StyleValidation.markRed(textfield);
			}
		});
	}



	public void addEmptyListenerSlider(Slider slider) {
		slider.valueProperty().addListener((e) -> {
			if (slider.getValue() != 0) {
				StyleValidation.unMark(slider);
			} else {
				StyleValidation.markRed(slider);
			}
		});
	}

	public void addEmptyListenerDatePicker(DatePicker datePicker) {
		datePicker.valueProperty().addListener((e) -> {
			if (datePicker.getValue() != null) {
				StyleValidation.unMark(datePicker);
			} else {
				StyleValidation.markRed(datePicker);
			}
		});
	}

	public void addEmptyListenerChoiceBox(ChoiceBox choiceBox) {
		choiceBox.valueProperty().addListener((e) -> {
			if (choiceBox.getSelectionModel() != null) {
				StyleValidation.unMark(choiceBox);
			}
		});
	}


}
