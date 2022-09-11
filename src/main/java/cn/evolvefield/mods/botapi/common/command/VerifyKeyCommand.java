package cn.evolvefield.mods.botapi.common.command;

import cn.evolvefield.mods.botapi.BotApi;
import cn.evolvefield.mods.botapi.common.config.ConfigManger;
import cn.evolvefield.mods.botapi.core.bot.BotData;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class VerifyKeyCommand {


    public static int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var id = context.getArgument("VerifyKey", String.class);
        BotData.setVerifyKey(id);
        BotApi.config.getCommon().setMiraiVerifyKey(id);
        ConfigManger.saveBotConfig(BotApi.config);
        context.getSource().sendSuccess(
                Component.literal("已设置Mirai框架的VerifyKey为:" + id), true);
        return 0;
    }


}
