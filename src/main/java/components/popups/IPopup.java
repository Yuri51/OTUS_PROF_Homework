package components.popups;

import data.StatePopupData;
import exceptions.PathEmptyException;


public interface IPopup<T> {

  T statePopup(StatePopupData statePopupData) throws PathEmptyException;

}
