package br.com.chamado.converte;

import br.com.chamado.dao.DaoGrupo;
import br.com.chamado.dao.DaoUnidade;
import br.com.chamado.model.Grupo;
import br.com.chamado.model.Unidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.JOptionPane;


@FacesConverter(forClass = Grupo.class, value = "grupoConverter")
public class ConverterGrupo implements Converter {

     public ConverterGrupo()
     {
       
     }
     public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
         
	 if ((value == null) || (value.length() == 0)) {
                return null;
            }
	  
           DaoGrupo dao = new DaoGrupo();
           
	   return dao.carregarUm(getID(value), Grupo.class);
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

            if (value instanceof Grupo) {
                Grupo o = (Grupo) value;
		
                return getStringID(o.getCodgrupo());
            } else {
        
		throw new IllegalArgumentException("objeto " + value + " possui o tipo "
                        + value.getClass().getName()
                        + "; tipo esperado: " );
            }
    }

  }
