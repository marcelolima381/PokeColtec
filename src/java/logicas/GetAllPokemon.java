package logicas;
 
import DAOs.AbilityDAO;
import DAOs.PokemonDAO;
import DAOs.TipoDAO;
import DAOs.pokemonTipoDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import conect.TypeDeserializer;
import conect.pegaJson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Ability;
import models.PokeTipo;
import models.Pokemon;
import models.Tipo;
 
/**
 *
 * @author strudel
 */
public class GetAllPokemon implements Logica{
 
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
       
        PokemonDAO dao = new PokemonDAO();
        TipoDAO tDao = new TipoDAO();
        AbilityDAO abiDAO = new AbilityDAO();
        pokemonTipoDAO pkt = new pokemonTipoDAO();
        
        List<PokeTipo> PT = pkt.getAll();
        List<Pokemon> pokemons = dao.getAll();
        
        List<Tipo> tipos = tDao.getAll();
        List<Ability> abilities = abiDAO.getAll();
        
          
        
        System.out.println("VOU COMEÇAR A FAZER ALGUMA COISA");
        
    for(int i=0;i<pokemons.size();i++){
            Pokemon provisorio = pokemons.get(i);
            provisorio.types = new ArrayList<>();
            
            for(int j=0;j<PT.size();j++){
                if(PT.get(j).getPokemonID()==provisorio.getId()){
                    Tipo tip = (Tipo) tDao.getById(PT.get(j).getTipoID());
                    provisorio.types.add(tip.getName());
                }
            }
            pokemons.set(i, provisorio);
            System.out.println((i*100)/pokemons.size() + " % concluídos");
        }
  
     GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Tipo.class, new TypeDeserializer());
    Gson gson = gsonBuilder.create();
     
  System.out.println("TIPOS COLOCADOS\n\n");
    
  
 /*  for(int i=0;i<pokemons.size();i++){
       Pokemon temporario = pokemons.get(i);
       temporario.types = new ArrayList<String>();
        for(int j=0;j<tipos.size();j++){
         Tipo Tprov = tipos.get(j);
            for(int k=0; k<Tprov.pokemons.size();k++){
                if(temporario.getName().equals(Tprov.pokemons.get(k))){
                   temporario.types.add(Tprov.getName());
                   
                  PokeTipo poketipo = new PokeTipo();
                   poketipo.setPokemonID(temporario.getId());
                   poketipo.setTipoID(Tprov.getId());
                   
                   PT.add(poketipo);
                   pkt.insert(poketipo);
                }
            }         
       }    
    }*/
  
     
  
         
      for(int i=0;i<pokemons.size();i++){
        Pokemon temporario = new Pokemon();        
        temporario = pokemons.get(i);
         
        if (pokemons.get(i).getId() < 10) {
                  temporario.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+pokemons.get(i).getId()+".png");
              }
              else if(pokemons.get(i).getId() >= 10 && pokemons.get(i).getId() < 100) {
                  temporario.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+pokemons.get(i).getId()+".png");
              }
              else {
                  temporario.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+pokemons.get(i).getId()+".png");
              }
         
                             
           
        pokemons.set(i, temporario);
      }
       
       
         
       
         
        Gson gson3 = new Gson();
        String json = gson3.toJson(pokemons);////<- O que o postman tá vendo
        //System.out.println(json);  
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);
    
     
    }
     
}