package gau.state;

import gau.models.RealTeam;

import java.util.List;

public final class State {
   
   private static boolean test;
   private static List<RealTeam> teams;
   private static Persistence db;

   private State() {
   }
   
   public static boolean isTest() {
      return test;
   }

   public static void init(String env) throws Exception{
      db = new Persistence();
      setEnv(env);
      setTeams(env);
   }

   public static void setTeams(String env) throws Exception{
      teams = db.getTeams();
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
