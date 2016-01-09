package br.com.chamado.converte;

import br.com.chamado.dao.DaoPermissao;
import br.com.chamado.model.Permissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@FacesConverter(forClass = Permissao.class, value = "permissaoConverter")
public class ConvertePermissao {
     public ConvertePermissao()
     {
       
     }
     public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
         
	 if ((value == null) || (value.length() == 0)) {
                return null;
            }
	  
           DaoPermissao dao = new DaoPermissao();
           
	   return dao.carregarUm(getID(value), Permissao.class);
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

            if (value instanceof Permissao) {
                Permissao o = (Permissao) value;
		
                return getStringID(o.getId());
            } else {
        
		throw new IllegalArgumentException("objeto " + value + " possui o tipo "
                        + value.getClass().getName()
                        + "; tipo esperado: " );
            }
    }

    
}
