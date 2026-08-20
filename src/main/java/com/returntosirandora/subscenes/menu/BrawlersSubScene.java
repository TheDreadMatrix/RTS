package com.returntosirandora.subscenes.menu;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

import com.returntosirandora.characters.content.Characters;
import com.returntosirandora.characters.defenition.CharacterDescription;
import com.returntosirandora.subscenes.BaseSubScene;
import com.returntosirandora.utils.ui.DrawableManager;
import com.returntosirandora.utils.ui.TrueTypeFont;

public class BrawlersSubScene extends BaseSubScene {

        private Table root;

        private final DrawableManager drawableMan = new DrawableManager();

        private BitmapFont font;

        @Override
        public void create(Stage stage) {

                font = TrueTypeFont.getFont(
                                game.getPaths().getFont("PixelFont.ttf"),
                                16,
                                Color.BLACK,
                                Color.WHITE);

                root = new Table();
                root.setFillParent(true);
                root.pad(20);

                /*
                 * Заголовок
                 */
                Label.LabelStyle titleStyle = new Label.LabelStyle();

                titleStyle.font = font;

                Label title = new Label("BRAWLERS", titleStyle);

                root.add(title)
                                .left()
                                .padBottom(15)
                                .row();

                /*
                 * Контент ScrollPane
                 */
                Table brawlersTable = createBrawlersTable();

                /*
                 * ScrollPane
                 */
                ScrollPaneStyle scrollStyle = new ScrollPaneStyle();

                ScrollPane scrollPane = new ScrollPane(
                                brawlersTable,
                                scrollStyle);

                scrollPane.setFadeScrollBars(false);

                root.add(scrollPane)
                                .grow()
                                .fill();

                stage.addActor(root);
        }

        private Table createBrawlersTable() {

                Table table = new Table();

                /*
                 * Получаем всех персонажей.
                 *
                 * Здесь подставь свой способ хранения
                 * персонажей в Characters.
                 */
                List<CharacterDescription> characters = List.of(
                                Characters.FRED,
                                Characters.DREAD_MATRIX);

                int column = 0;

                for (CharacterDescription character : characters) {

                        Table card = createBrawlerCard(character);

                        table.add(card)
                                        .width(240)
                                        .height(300)
                                        .pad(10);

                        column++;

                        /*
                         * 3 персонажа в одной строке.
                         */
                        if (column >= 3) {

                                table.row();

                                column = 0;
                        }
                }

                return table;
        }

        private Table createBrawlerCard(
                        CharacterDescription character) {

                Table card = new Table();

                card.setTransform(true);

                /*
                 * NAME
                 */
                Label.LabelStyle nameStyle = new Label.LabelStyle();

                nameStyle.font = font;

                Label name = new Label(
                                character.getName(),
                                nameStyle);

                card.add(name)
                                .center()
                                .padTop(10)
                                .row();

                /*
                 * RARITY
                 */
                Label rarity = new Label(
                                character.getRarity()
                                                .getDisplayName(),
                                nameStyle);

                card.add(rarity)
                                .center()
                                .padTop(5)
                                .row();

                /*
                 * CLASS
                 */
                Label characterClass = new Label(
                                character
                                                .getClassCharacter()
                                                .getDisplayName(),
                                nameStyle);

                card.add(characterClass)
                                .center()
                                .padTop(5)
                                .row();

                /*
                 * TYPE
                 */
                Label type = new Label(
                                character
                                                .getTypeCharacter()
                                                .getDisplayName(),
                                nameStyle);

                card.add(type)
                                .center()
                                .padTop(5)
                                .row();

                /*
                 * STATS
                 */
                Label stats = new Label(
                                "HP: " + character.getHealth()
                                                + "\nSpeed: " + character.getSpeed()
                                                + "\nSpeedUp: " + character.getSpeedUp()
                                                + "\nStamina: " + character.getStamina(),
                                nameStyle);

                card.add(stats)
                                .center()
                                .padTop(15)
                                .row();

                /*
                 * CLICK
                 */
                card.addListener(
                                createCardListener(
                                                card,
                                                character));

                /*
                 * Размер origin для scale.
                 */
                card.pack();

                card.setOrigin(
                                card.getWidth() / 2f,
                                card.getHeight() / 2f);

                return card;
        }

        private InputListener createCardListener(
                        Actor actor,
                        CharacterDescription character) {

                return new InputListener() {

                        @Override
                        public void enter(
                                        InputEvent event,
                                        float x,
                                        float y,
                                        int pointer,
                                        Actor fromActor) {

                                actor.clearActions();

                                actor.addAction(
                                                Actions.scaleTo(
                                                                1.05f,
                                                                1.05f,
                                                                0.1f));
                        }

                        @Override
                        public void exit(
                                        InputEvent event,
                                        float x,
                                        float y,
                                        int pointer,
                                        Actor toActor) {

                                actor.clearActions();

                                actor.addAction(
                                                Actions.scaleTo(
                                                                1f,
                                                                1f,
                                                                0.1f));
                        }

                        @Override
                        public boolean touchDown(
                                        InputEvent event,
                                        float x,
                                        float y,
                                        int pointer,
                                        int button) {

                                actor.clearActions();

                                actor.addAction(
                                                Actions.scaleTo(
                                                                0.95f,
                                                                0.95f,
                                                                0.05f));

                                return true;
                        }

                        @Override
                        public void touchUp(
                                        InputEvent event,
                                        float x,
                                        float y,
                                        int pointer,
                                        int button) {

                                actor.clearActions();

                                actor.addAction(
                                                Actions.scaleTo(
                                                                1.05f,
                                                                1.05f,
                                                                0.05f));

                                /*
                                 * Например:
                                 *
                                 * redirect.accept(
                                 * "brawler/" + character.getId()
                                 * );
                                 */

                                redirect.accept(
                                                "brawler/" + character.getId());
                        }
                };
        }

        @Override
        public void dispose() {

                if (root != null) {
                        root.remove();
                }

                drawableMan.dispose();
        }
}