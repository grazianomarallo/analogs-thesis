package it.unisannio.loganalysis.presentation.components;

import com.vaadin.data.Property;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.UserError;
import com.vaadin.ui.*;
import it.unisannio.loganalysis.extractor.FacadeLogSource;

/**
 * Created by grazianoS on 03/07/16.
 */
public class AddLogSourceForm extends CustomComponent {

    private ComboBox serviceTypeCb;
    private ComboBox dialect;
    private TextField host;
    private TextField port;
    private TextField dbname;
    private TextField username;
    private PasswordField password;
    private Button confirmButton;

    public AddLogSourceForm() {
        FormLayout form = new FormLayout();

//
        serviceTypeCb = new ComboBox();
        serviceTypeCb.setNullSelectionAllowed(false);
        serviceTypeCb.addItems(FacadeLogSource.getInstance().getDataSourcesTypes());
        serviceTypeCb.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                serviceTypeCb.setComponentError(null);
            }
        });

        dialect = new ComboBox("Tipo Database");
        dialect.addItem("mysql");
        dialect.addItem("postgresql");
        dialect.setNullSelectionAllowed(false);
        dialect.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                dialect.setComponentError(null);
            }
        });


        host = new TextField("Host");
        host.setRequired(true);
        host.addValidator(new NullValidator("Campo obbligatorio", false));
        host.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                host.setComponentError(null);
            }
        });

        port = new TextField("Port");
        port.setRequired(true);
        port.addValidator(new NullValidator("Campo obbligatorio", false));
        port.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                port.setComponentError(null);
            }
        });

        dbname = new TextField("Nome del database");
        dbname.setRequired(true);
        dbname.addValidator(new NullValidator("Campo obbligatorio", false));
        dbname.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                dbname.setComponentError(null);
            }
        });

        username = new TextField("Username");
        username.setIcon(FontAwesome.USER);
        username.setRequired(true);
        username.addValidator(new NullValidator("Campo obbligatorio", false));
        username.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                username.setComponentError(null);
            }
        });

        password = new PasswordField("Password");
        password.setRequired(true);
        password.addValidator(new NullValidator("Campo obbligatorio", false));
        password.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                password.setComponentError(null);
            }
        });

        confirmButton = new Button("Aggiungi");

        form.addComponent(serviceTypeCb);
        form.addComponent(dialect);
        form.addComponent(host);
        form.addComponent(port);
        form.addComponent(dbname);
        form.addComponent(username);
        form.addComponent(password);
        form.addComponent(confirmButton);

        form.setMargin(true);
        form.setSpacing(true);

        setCompositionRoot(form);
    }

    public void setAddListener(Button.ClickListener listener) {
        confirmButton.addClickListener(listener);




    }

    public String getType() {
        return (String) serviceTypeCb.getValue();
    }

    public String getDialect() {
        return (String) dialect.getValue();
    }

    public String getHost() {
        return host.getValue();
    }

    public String getPort() {
        return port.getValue();
    }

    public String getSourceDb() {
        return dbname.getValue();
    }

    public String getUsername() {
        return username.getValue();
    }

    public String getPassword() {
        return password.getValue();
    }

    public void serviceTypeCbError(){serviceTypeCb.setComponentError(new UserError("Campo vuoto"));}
    public void dialectError(){dialect.setComponentError(new UserError("Campo vuoto"));}
    public void hostError(){host.setComponentError(new UserError("Campo vuoto"));}
    public void portError(){port.setComponentError(new UserError("Campo vuoto"));}
    public void dbnameError(){dbname.setComponentError(new UserError("Campo vuoto"));}
    public void usernameError(){username.setComponentError(new UserError("Campo vuoto"));}
    public void passwordError(){password.setComponentError(new UserError("Campo vuoto"));}


}
