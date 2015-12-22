package br.com.chamado.converte;

import br.com.chamado.dao.DaoPagina;
import br.com.chamado.dao.DaoUnidade;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Unidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.JOptionPane;


@FacesConverter(forClass = Pagina.class, value = "paginaConverter")
public class ConverterPagina implements Converter {

     public ConverterPagina()
     {
       
     }
     public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
         
	 if ((value == null) || (value.length() == 0)) {
                return null;
            }
	  
           DaoPagina dao = new DaoPagina();
           
	   return dao.carregarUm(getID(value), Pagina.class);
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

            if (value instanceof Pagina) {
                Pagina o = (Pagina) value;
		
                return getStringID(o.getId());
            } else {
        
		throw new IllegalArgumentException("objeto " + value + " possui o tipo "
                        + value.getClass().getName()
                        + "; tipo esperado: " );
            }
    }

  }
