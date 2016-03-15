package joptsimple;

import java.util.Collection;

public abstract interface OptionDeclarer {
	public abstract OptionSpecBuilder accepts(String paramString);

	public abstract OptionSpecBuilder accepts(String paramString1, String paramString2);

	public abstract OptionSpecBuilder acceptsAll(Collection<String> paramCollection);

	public abstract OptionSpecBuilder acceptsAll(Collection<String> paramCollection, String paramString);

	public abstract NonOptionArgumentSpec<String> nonOptions();

	public abstract NonOptionArgumentSpec<String> nonOptions(String paramString);

	public abstract void posixlyCorrect(boolean paramBoolean);

	public abstract void allowsUnrecognizedOptions();

	public abstract void recognizeAlternativeLongOptions(boolean paramBoolean);
}