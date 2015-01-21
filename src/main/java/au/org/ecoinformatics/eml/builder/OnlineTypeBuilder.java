package au.org.ecoinformatics.eml.builder;

import au.org.ecoinformatics.eml.jaxb.ConnectionDefinitionType;
import au.org.ecoinformatics.eml.jaxb.ConnectionType;
import au.org.ecoinformatics.eml.jaxb.I18NNonEmptyStringType;
import au.org.ecoinformatics.eml.jaxb.OnlineType;
import au.org.ecoinformatics.eml.jaxb.UrlType;

public class OnlineTypeBuilder {

	private String url;
	private ConnectionType connection;
	private ConnectionDefinitionType connectionDefinition;
	private String onlineDescription;

	public OnlineTypeBuilder(String url) {
		this.url = url;
	}

	public OnlineTypeBuilder(ConnectionTypeBuilder connectionBuilder) {
		this.connection = connectionBuilder.build();
	}

	public OnlineTypeBuilder(ConnectionDefinitionTypeBuilder connectionDefinitionTypeBuilder) {
		this.connectionDefinition = connectionDefinitionTypeBuilder.build();
	}

	public OnlineTypeBuilder onlineDescription(String onlineDescription) {
		this.onlineDescription = onlineDescription;
		return this;
	}
	
	public OnlineType build() {
		OnlineType result = new OnlineType();
		if (isSupplied(url)) {
			UrlType value = new UrlType();
			value.setValue(url);
			result.setUrl(value);
		}
		if (isSupplied(connection)) {
			result.setConnection(connection);
		}
		if (isSupplied(connectionDefinition)) {
			result.setConnectionDefinition(connectionDefinition);
		}
		if (isSupplied(onlineDescription)) {
			I18NNonEmptyStringType value = new I18NNonEmptyStringTypeBuilder(onlineDescription).build();
			result.setOnlineDescription(value);
		}
		return result;
	}

	private boolean isSupplied(Object obj) {
		return obj != null;
	}
}
