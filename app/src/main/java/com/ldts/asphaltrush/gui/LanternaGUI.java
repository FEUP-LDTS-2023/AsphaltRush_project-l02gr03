package com.ldts.asphaltrush.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class LanternaGUI implements GUI {

    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }


    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("images/fonts/square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 4);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        KeyStroke nextKey = screen.pollInput();

        while(nextKey != null) {
            keyStroke = nextKey;
            nextKey = screen.pollInput();
        }

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawImage(Position position, Image image){
        drawImage(position, image, 'l', 't');
    }
    @Override
    public void drawImage(Position position, Image image, char htype, char vtype) {
        String[][] colorMatrix = image.getColorMatrix();
        int x = position.getX();
        int y = position.getY();
        switch (htype){
            case 'c':
                x = position.getX() - image.getWidth()/2;
                break;
            case 'r':
                x = position.getX() - image.getWidth();
                break;
        }

        switch (vtype){
            case 'c':
                y = position.getY() - image.getHeight()/2;
                break;
            case 'b':
                y = position.getY() - image.getHeight();
                break;

        }


        TextGraphics tg = screen.newTextGraphics();
        for (int i = 0; i < image.getHeight(); i++){
            for (int j = 0; j< image.getWidth(); j++){

                String color = colorMatrix[i][j];

                if (Objects.equals(color, " ")) continue;
                tg.setBackgroundColor(TextColor.Factory.fromString(color));
                tg.setForegroundColor(TextColor.Factory.fromString(color));
                tg.putString(j+x, i+y, " ");

            }
        }
    }


    @Override
    public void drawRectangle(Position position, int width, int height, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(width, height), ' ');
    }


    @Override
    public void drawText(String text, Position position, ImageFactory imageFactory, char type){
        drawText(text, position, imageFactory, type, false);
    }
    @Override
    public void drawText(String text, Position position, ImageFactory imageFactory, char type, boolean smallNumbers){
        int x = position.getX();
        int y = position.getY();
        switch (type){
            case 'c':
                int textWidth = 0;
                for (int i=0; i<text.length(); i++){
                    textWidth += (Character.isDigit(text.charAt(i))&&smallNumbers) ? 7: 10;
                }
                x -= textWidth/2;
            case 'l':
                for (int i=0; i<text.length(); i++){
                    if (text.charAt(i) == ' '){
                        x += 10;
                        continue;
                    }
                    String path = Character.isAlphabetic(text.charAt(i)) ? "letters/" : smallNumbers ? "numbers/small/": "numbers/big/" ;
                    Image image = imageFactory.getImage("/fonts/" + path + text.charAt(i));
                    drawImage(new Position(x, y), image);
                    x += image.getWidth();
                }
                break;
            case 'r':
                for (int i=text.length()-1; i>=0; i--){
                    if (text.charAt(i) == ' '){
                        x -= 10;
                        continue;
                    }
                    String path = Character.isAlphabetic(text.charAt(i)) ? "letters/" : smallNumbers ? "numbers/small/": "numbers/big/" ;
                    Image image = imageFactory.getImage("/fonts/" + path + text.charAt(i));
                    x-= image.getWidth() + 1;
                    drawImage(new Position(x, y), image);
                }
                break;
        }
    }

}
