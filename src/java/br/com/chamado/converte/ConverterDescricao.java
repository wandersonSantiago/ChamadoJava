package br.com.chamado.converte;


import br.com.chamado.dao.DaoDescricao;
import br.com.chamado.model.Descricao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.JOptionPane;


@FacesConverter(forClass = Descricao.class, value = "descricaoConverter")
public class ConverterDescricao implements Converter {

     public ConverterDescricao()
     {
       
     }
     public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
         
	 if ((value == null) || (value.length() == 0)) {
                return null;
            }
	  
           DaoDescricao dao = new DaoDescricao();
           
	   return dao.carregarUm(getID(value), Descricao.class);
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

            if (value instanceof Descricao) {
                Descricao o = (Descricao) value;
		
                return getStringID(o.getId());
            } else {
        
		throw new IllegalArgumentException("objeto " + value + " possui o tipo "
                        + value.getClass().getName()
                        + "; tipo esperado: " );
            }
    }

  }
