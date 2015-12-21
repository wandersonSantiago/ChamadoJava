package br.com.chamado.converte;

import br.com.chamado.dao.DaoUnidade;
import br.com.chamado.model.Unidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.JOptionPane;


@FacesConverter(forClass = Unidade.class, value = "unidadeConverter")
public class converteUnidade implements Converter {

     public converteUnidade()
     {
       
     }
     public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
         
	 if ((value == null) || (value.length() == 0)) {
                return null;
            }
	  
           DaoUnidade dao = new DaoUnidade();
           
	   return dao.carregarUm(getID(value), Unidade.class);
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

            if (value instanceof Unidade) {
                Unidade o = (Unidade) value;
		
                return getStringID(o.getCodunidade());
            } else {
        
		throw new IllegalArgumentException("objeto " + value + " possui o tipo "
                        + value.getClass().getName()
                        + "; tipo esperado: " );
            }
    }

  }
