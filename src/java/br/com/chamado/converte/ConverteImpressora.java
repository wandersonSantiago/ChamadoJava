package br.com.chamado.converte;

import br.com.chamado.dao.DaoImpressora;

import br.com.chamado.model.Impressora;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author wandersonSantiago
 */
@FacesConverter(forClass = Impressora.class, value = "impressoraConverter")
public class ConverteImpressora {

    public ConverteImpressora() {

    }

    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

        if ((value == null) || (value.length() == 0)) {
            return null;
        }

        DaoImpressora dao = new DaoImpressora();

        return dao.carregarUm(getID(value), Impressora.class);
    }

    Integer getID(String value) {
        Integer id;
        id = Integer.valueOf(value);
        return id;
    }

    String getStringID(Integer value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null) {

            return null;
        }

        if (value instanceof Impressora) {
            Impressora o = (Impressora) value;

            return getStringID(o.getId());
        } else {

            throw new IllegalArgumentException("objeto " + value + " possui o tipo "
                    + value.getClass().getName()
                    + "; tipo esperado: ");
        }
    }

}
