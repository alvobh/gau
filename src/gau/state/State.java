package gau.state;

import gau.models.RealTeam;

import java.util.ArrayList;
import java.util.List;

public final class State {

   private static boolean test;
   private static List<RealTeam> teams;
   private static Abstraction db;

   private State() {
      return;
   }

   public static boolean isTest() {
      return test;
   }

   public static void init(String env) throws Exception{
      db = new Abstraction();
      setEnv(env);
      setTeams(env);
   }

   public static void setTeams(String env) throws Exception{
      List<AbstractType> aux = db.get(RealTeam.class);
      teams = new ArrayList<RealTeam>();
      for (AbstractType rteam : aux) {
         teams.add((RealTeam) rteam);
      }
   }

   public static void setEnv(String env){
      if (env.equals("test")) {
         test = true;
      } else {
         test = false;
      }
   }
   
   public static List<RealTeam> getTeams() {
      return teams;
   }

}
