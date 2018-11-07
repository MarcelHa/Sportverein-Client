package utilities;

import javafx.scene.control.*;


public class StyleValidation {
	private static final String _redMarkString = "-fx-border-color: red ; -fx-border-width: 2px;";
	private static final String _redMarkBoldString = "-fx-border-color: red ; -fx-border-width: 2px; -fx-font-weight: bold";

	public static void markRed(Control control) {
		control.setStyle(_redMarkString);
	}

	public static void markRedBold(Control control) {
		control.setStyle(_redMarkBoldString);
	}

	public static void unMark(Control control) {
		control.setStyle(null);
	}

	public boolean markedEmpty(TextField textfield) {
		if (textfield.getText() == null || textfield.getText().equals("")) {
			markRed(textfield);
			return true;
		} else {
			unMark(textfield);
			return false;
		}
	}

	public boolean markedEmpty(ChoiceBox choiceBox) {
		if (choiceBox.getSelectionModel().isEmpty()) {
			markRed(choiceBox);
			return true;
		} else {
			unMark(choiceBox);
			return false;
		}
	}

	public boolean markedEmpty(DatePicker date) {
		if (date.getValue() == null) {
			markRed(date);
			return true;
		} else {
			unMark(date);
			return false;
		}
	}

	public boolean markedEmpty(Slider slider) {
		if (slider.getValue() == 0) {
			markRed(slider);
			return true;
		} else {
			unMark(slider);
			return false;
		}
	}

	public boolean markedArrivalAndDeparture(DatePicker arrival, DatePicker departure) {
		boolean isMarked = false;
		FieldValidation validate = new FieldValidation();
		if (!validate.dateCompareNow(arrival)) {
			markRed(arrival);
			isMarked = true;
		} else {
			unMark(arrival);
		}
		if (!validate.dateCompareNow(departure)) {
			markRed(departure);
			isMarked = true;
		} else {
			unMark(departure);
		}
		if (!isMarked && !validate.arrivalCompareDeparture(arrival, departure)) {
			markRed(departure);
			isMarked = true;
		}
		return isMarked;
	}

	public boolean markedMail(TextField mail) {
		FieldValidation validate = new FieldValidation();
		if ((mail.getText() == null) || mail.getText().equals("")) {
			unMark(mail);
			return false;
		} else {
			if (!validate.mail(mail)) {
				markRed(mail);
				return true;
			} else {
				unMark(mail);
				return false;
			}
		}
	}

	public boolean markedQuantity(TextField quantity, int available) {
		FieldValidation validate = new FieldValidation();
		if (validate.isQuantityNumber(quantity)) {
			if (validate.quantityCompareAvailable(quantity, available)) {
				unMark(quantity);
				return true;
			} else {
				markRed(quantity);
				return false;
			}
		} else {
			unMark(quantity);
			return false;
		}
	}

	public boolean markedListEntry(Object listEntry) {
		boolean isMarked = false;
		if (listEntry.getClass().equals(TextField.class)) {
			if (markedEmpty((TextField) listEntry)) {
				isMarked = true;
			}
		}
		if (listEntry.getClass().equals(Slider.class)) {
			if (markedEmpty((Slider) listEntry)) {
				isMarked = true;
			}
		}
		if (listEntry.getClass().equals(DatePicker.class)) {
			if (markedEmpty((DatePicker) listEntry)) {
				isMarked = true;
			}
		}
		if (listEntry.getClass().equals(ChoiceBox.class)) {
			if (markedEmpty((ChoiceBox) listEntry)) {
				isMarked = true;
			}
		}
		return isMarked;
	}
}
