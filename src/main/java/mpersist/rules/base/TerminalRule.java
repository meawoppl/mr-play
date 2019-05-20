package mpersist.rules.base;

public abstract class TerminalRule extends Rule {
  @Override
  public boolean isTerminal() {
    return true;
  }
}
