package contract;

public interface IHero {
	public void setStateImage(StateHero state);

	public StateHero getState();

	public boolean isStateSpell();

	public void setStateSpell(boolean stateSpell);

}
