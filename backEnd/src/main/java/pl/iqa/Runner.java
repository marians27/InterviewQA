package pl.iqa;

import pl.iqa.init.jetty.EmbeddedJetty;

public class Runner {

    private static final String APPLICATION_NAME = "iqa-ws";

    public static void main(String[] args) throws Exception {
        EmbeddedJetty embeddedJetty = new EmbeddedJetty(extractPortNumber(args), APPLICATION_NAME);
        embeddedJetty.startAndJoin();
    }

    private static Integer extractPortNumber(String[] args) {
        if (args.length > 0) {
            return Integer.parseInt(args[0]);
        }
        return null;
    }

}
