//==============================================================================================

    package com.saftno.compressions;

//==============================================================================================

    import net.minecraft.item.crafting.IRecipe;
    import net.minecraftforge.client.event.GuiScreenEvent.DrawScreenEvent;
    import net.minecraftforge.event.RegistryEvent.Register;
    import net.minecraftforge.fml.common.Mod;
    import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//=============================================================================================

    import java.nio.file.Path;
    import java.nio.file.Paths;

//==============================================================================================
    @Mod.EventBusSubscriber
//----------------------------------------------------------------------------------------------
    @Mod( modid   = Base.modId   , dependencies = "after:*" ,
          name    = Base.name    , acceptedMinecraftVersions = "[1.12 , 1.12.1]"  ,
          version = Base.version )
//----------------------------------------------------------------------------------------------
    @SuppressWarnings( { "WeakerAccess" , "CanBeFinal" } )
//==============================================================================================

    public class Base {

    //==========================================================================================
    // Forge
    //==========================================================================================

        public static final String modId   = "compressions";
        public static final String name    = "Compressions";
        public static final String version = "2.0.2";

    //==========================================================================================
        @Mod.Instance( modId )
    //==========================================================================================

        public static Base instance;

    //==========================================================================================
    // Initialization
    //==========================================================================================

        public static Boolean once = false;
        public static Path    root = Paths.get( System.getProperty( "user.dir" ) );

    //==========================================================================================
        @SubscribeEvent
    //==========================================================================================

        public static void Register( Register<IRecipe> event ) {
        //--------------------------------------------------------------------------------------

            ItemBlocks.Register();
            Recipes.Register();
            Languages.Register();

        //--------------------------------------------------------------------------------------
        }

    //==========================================================================================
        @SubscribeEvent
    //==========================================================================================

        public static void Register( DrawScreenEvent event ) {
        //--------------------------------------------------------------------------------------
            if( once ) return;
        //--------------------------------------------------------------------------------------

            Textures.Register();
            Models.Register();

        //--------------------------------------------------------------------------------------

            ResourcePacks.Register();

            Textures.saveAllToFile();

        //--------------------------------------------------------------------------------------
            once = true;
        //--------------------------------------------------------------------------------------
        }

    //==========================================================================================

    }

//==============================================================================================
