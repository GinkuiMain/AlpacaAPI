package AlpacaAPI.PlayneeTesting;

public class AlpacaAPISettings {

    public String APITokenCall()  // Seu token de acesso da GraphAPI - Substitua ali.
    {
        return "TOKENDEACESSO";
    }

    public String ImagePostURLCall()  // Use para postar imagens
    {                                        //COLOQUE SEU ID AQUI
        return "https://graph.facebook.com/v19.0/---------------/photos";
    }//                                         |---------------|

    public String MessagePostURlCall()  // Use para postar apenas mesagens
    {                                        //COLOQUE SEU ID AQUI
        return "https://graph.facebook.com/v19.0/---------------/feed";
    }//                                         |---------------|
}