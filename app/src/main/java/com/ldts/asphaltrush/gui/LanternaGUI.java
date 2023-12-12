package com.ldts.asphaltrush.gui;

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
    public void drawImage(Position position, Image image) {

        int x = position.getX();
        int y = position.getY();

        String[][] colorMatrix = image.getColorMatrix();

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
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void drawBarrier(Position position) {
        drawCharacter(position.getX(), position.getY(), '▓', "#FFFFFF");
    }

    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(), position.getY(), '☗', "#FFFF00");
    }

    @Override
    public void drawLine(Position position) {
        drawCharacter(position.getX(), position.getY(), '|', "#FFFFFF");
    }

    @Override
    public void drawObstacleCar(Position position) {
        drawCharacter(position.getX(), position.getY(), '◙', "#FF0000");
    }

    @Override
    public void drawHole(Position position) {
        drawCharacter(position.getX(), position.getY(), '◉', "#967969");
    }

    @Override
    public void drawJump(Position position) {
        drawCharacter(position.getX(), position.getY(), '⍓', "#ADD8E6");
    }

    @Override
    public void drawPointMultiplierPowerUp(Position position) {
        drawCharacter(position.getX(), position.getY(), '◈', "#00BF00");
    }

    @Override
    public void drawInvenciblePowerUp(Position position) {
        drawCharacter(position.getX(), position.getY(), '★', "#BFF000");
    }
}
