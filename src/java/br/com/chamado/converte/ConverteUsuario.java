package br.com.chamado.converte;

import br.com.chamado.dao.DaoUnidade;
import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.JOptionPane;


@FacesConverter(forClass = Usuario.class, value = "usuarioConverter")
public class ConverteUsuario implements Converter {

     public ConverteUsuario()
     {
       
     }
     public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
         
	 if ((value == null) || (value.length() == 0)) {
                return null;
            }
	  
           DaoUsuario dao = new DaoUsuario();
           
	   return dao.carregarUm(getID(value), Usuario.class);
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

            if (value instanceof Usuario) {
                Usuario o = (Usuario) value;
		
                return getStringID(o.getId());
            } else {
        
		throw new IllegalArgumentException("objeto " + value + " possui o tipo "
                        + value.getClass().getName()
                        + "; tipo esperado: " );
            }
    }

  }
