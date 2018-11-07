package utilities;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class FieldValidation {

	public boolean dateCompareNow(DatePicker date) {
		if (date.getValue() == null) {
			return false;
		}
		if (date.getValue().compareTo(LocalDate.now()) < 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean arrivalCompareDeparture(DatePicker arrival, DatePicker departure) {
		if (arrival.getValue().compareTo(departure.getValue()) < 0) {
			return true;
		}
		return false;
	}


	public boolean mail(TextField mail) {
		if (mail.getText() == null || mail.getText().equals("")) {
			return false;
		}
		if (mail.getText().toLowerCase().matches("^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$")) {
			return true;
		}
		return false;
	}

	public boolean price(TextField price) {
		if (price.getText() == null || price.getText().equals("")) {
			return false;
		}
		if (price.getText().matches("^(?:0|[1-9][0-9]{0,2}(?:\\.[0-9]{3})*),[0-9]{2}$")) {
			return true;
		}
		return false;
	}

	public boolean isQuantityNumber(TextField quantity) {
		if (quantity.getText() == null || quantity.getText().equals("")) {
			return true;
		}
		if (quantity.getText().matches("^[0-9]*$")) {
			return true;
		}
		return false;
	}

	public boolean quantityCompareAvailable(TextField quantity, int available) {
		if (quantity.getText() == null || quantity.getText().equals("")) {
			return true;
		}
		if (quantity.getText().matches("^[0-9]*$")) {
			int intQuantity = Integer.parseInt(quantity.getText());
			if (intQuantity != 0 && intQuantity > available) {
				return false;
			}
			return true;
		}
		return false;
	}
}

