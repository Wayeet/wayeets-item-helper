package com.wayeet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mojang.brigadier.Command;
import static net.minecraft.server.command.CommandManager.*;

public class WayeetsItemHelperClient implements ClientModInitializer {
	public static final String MOD_ID = "wayeets-item-helper";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		LOGGER.info("Frontend intialized");

		Command<ServerCommandSource> command = context -> {
			return 0;
		};


		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("testgui")
		.executes(context -> {
			context.getSource().sendFeedback(() -> Text.literal("GUI geöffnet"), false);

			this.openScreen();

			return 1;
		})));
	}

	public void openScreen(){
		CustomScreen screen = new CustomScreen();
		screen.init();
		MinecraftClient.getInstance().setScreenAndRender(screen); //klappt irgendwie nicht. Dann halt nicht
	}


}