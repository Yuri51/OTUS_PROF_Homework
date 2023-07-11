package data;

public enum StatePopupData {

  VISIBLE(true),
  INVISIBLE(false);
  private boolean state;
  StatePopupData(boolean state) {
    this.state = state;
  }
  public boolean isState() {
    return state;
  }
}

