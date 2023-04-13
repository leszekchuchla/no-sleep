package org.lch;

import java.awt.*;
import java.util.Optional;

public class NoSleep {

  private static final long THREE_MINUTES = 1_000 * 60 * 3;

  public static void main(String[] args) throws AWTException, InterruptedException {
    var robot = new Robot();

    while(true) {
      var mousePosition = Optional.ofNullable(MouseInfo.getPointerInfo())
                                  .map(PointerInfo::getLocation)
                                  .orElseGet(() -> new Point(0, 0));

      robot.mouseMove(++mousePosition.x, ++mousePosition.y);
      Thread.sleep(THREE_MINUTES);
    }
  }

}
