/*
 * goPaint is designed to simplify painting inside of Minecraft.
 * Copyright (C) Arcaniax-Development
 * Copyright (C) Arcaniax team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.arcaniax.gopaint.utils;

import net.arcaniax.gopaint.GoPaintPlugin;
import net.arcaniax.gopaint.objects.brush.AngleBrush;
import net.arcaniax.gopaint.objects.brush.Brush;
import net.arcaniax.gopaint.objects.brush.BucketBrush;
import net.arcaniax.gopaint.objects.brush.DiscBrush;
import net.arcaniax.gopaint.objects.brush.FractureBrush;
import net.arcaniax.gopaint.objects.brush.GradientBrush;
import net.arcaniax.gopaint.objects.brush.OverlayBrush;
import net.arcaniax.gopaint.objects.brush.PaintBrush;
import net.arcaniax.gopaint.objects.brush.SphereBrush;
import net.arcaniax.gopaint.objects.brush.SplatterBrush;
import net.arcaniax.gopaint.objects.brush.SprayBrush;
import net.arcaniax.gopaint.objects.other.BlockType;
import net.arcaniax.gopaint.objects.player.PlayerBrush;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class GUI {

    private static final String headSphere = "fe98f48560147c0a2d4edc17f6d985e8eb5d94bd72fc60744a5a8f2d905a18";
    private static final String headSpray = "b880f765ea80dee37082dcdfd9812ee36fda8848692a841bec1bbd9ed51ba22";
    private static final String headSplatter = "3338292e2e69f090694cef672bb76f1d83758d12744bb6ffc6834fdbc1a983";
    private static final String headDisc = "b1f28250d1e420a6511b03964868fca2f5637e3aba79f4a163f4a8d613be";
    private static final String headBucket = "5018b4574939788a2ad5552b912d6781069888c51234a4a13eadb7d4c979c93";
    private static final String headAngle = "6de448f0dbe76bb8a832c8f3b2a03d35bd4e2785fa5e8298c2615503f47ffa2";
    private static final String headOverlay = "df31d6f9654f874ea9097adeea0c96996e78e3fd3754fbf9ebe963adad9be4c";
    private static final String headFracture = "23df73eee6224c5c5d948d2a345de25f208cbd9af7108ce1e1b61a586de98b2";
    private static final String headGradient = "6062da3d3b8f1fd35343cc279fb0fe5cf4a57b5abc431fbb78a73bf2af674f";
    private static final String headPaint = "80b3a9dfabefbdd949b217bbd4fa9a486bd0c3f0cab0d0b9dfa24c332dd3e342";
    private static final String headBlend = "5e9184af1de7e5b7c4ad411c56af4f9336653615929bc95d713b7a42cff3fbad";

    public static Inventory Generate(PlayerBrush pb) {
        Inventory inv = Bukkit.createInventory(null, 54, "§1goPaint Menu");
        Update(inv, pb);
        return inv;
    }

    public static Inventory GenerateBrushes() {
        Inventory inv = Bukkit.createInventory(null, 27, "§1goPaint Brushes");
        Items item = new Items();
        // FILLER
        for (int x = 0; x < 27; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.GRAY_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.GRAY_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }
        int x = 0;
        for (Brush b : GoPaintPlugin.getBrushManager().getBrushes()) {
            if (b instanceof SphereBrush) {
                inv.setItem(
                        x,
                        item.createHead(headSphere,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8Regular sphere brush"
                        )
                );
            } else if (b instanceof SprayBrush) {
                inv.setItem(
                        x,
                        item.createHead(headSpray,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8Configurable random chance brush"
                        )
                );
            } else if (b instanceof SplatterBrush) {
                inv.setItem(
                        x,
                        item.createHead(headSplatter,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8More chance when closer___&8to the clicked point___&8and configurable chance"
                        )
                );
            } else if (b instanceof DiscBrush) {
                inv.setItem(
                        x,
                        item.createHead(headDisc,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8Paints blocks in the___&8same selected axis___&8from the block you clicked"
                        )
                );
            } else if (b instanceof BucketBrush) {
                inv.setItem(
                        x,
                        item.createHead(headBucket,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8Paints connected blocks___&8with the same block type"
                        )
                );
            } else if (b instanceof AngleBrush) {
                inv.setItem(
                        x,
                        item.createHead(headAngle, 1, "&6" + b.getName(), "___&7Click to select______" + "&8Only works on cliffs")
                );
            } else if (b instanceof OverlayBrush) {
                inv.setItem(
                        x,
                        item.createHead(headOverlay,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8Only paints blocks___&8that have air above it"
                        )
                );
            } else if (b instanceof FractureBrush) {
                inv.setItem(
                        x,
                        item.createHead(headFracture,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8Places blocks in cracks/fisures"
                        )
                );
            } else if (b instanceof GradientBrush) {
                inv.setItem(
                        x,
                        item.createHead(headGradient, 1, "&6" + b.getName(), "___&7Click to select______" + "&8Creates gradients")
                );
            } else if (b instanceof PaintBrush) {
                inv.setItem(
                        x,
                        item.createHead(headPaint,
                                1,
                                "&6" + b.getName(),
                                "___&7Click to select______" + "&8Paints strokes___&8hold shift to end"
                        )
                );
            }
            x++;
        }
        return inv;
    }

    public static void Update(Inventory inv, PlayerBrush pb) {
        Items item = new Items();
        Brush b = pb.getBrush();

        // FILLER
        for (int x = 0; x < 54; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.GRAY_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.GRAY_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // goPaint toggle
        if (pb.isEnabled()) {
            inv.setItem(
                    1,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    10,
                    item.create(Material.FEATHER,
                            (short) 0,
                            1,
                            "&6goPaint Brush",
                            "&a&lEnabled______&7Left click with item to export___&7Right click to toggle"
                    )
            );
            inv.setItem(
                    19,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        } else {
            inv.setItem(
                    1,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    10,
                    item.create(Material.FEATHER,
                            (short) 0,
                            1,
                            "&6goPaint Brush",
                            "&c&lDisabled______&7Left click with item to export___&7Right click to toggle"
                    )
            );
            inv.setItem(
                    19,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // Brushes + Chance
        inv.setItem(
                2,
                item.create(XMaterial.ORANGE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.ORANGE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );


        String clicks = "___&7Shift click to select___&7Click to cycle brush______";
        if (b instanceof SphereBrush) {
            inv.setItem(
                    11,
                    item.createHead(headSphere,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof SprayBrush) {
            inv.setItem(
                    11,
                    item.createHead(headSpray,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof SplatterBrush) {
            inv.setItem(
                    11,
                    item.createHead(headSplatter,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof DiscBrush) {
            inv.setItem(
                    11,
                    item.createHead(headDisc,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof BucketBrush) {
            inv.setItem(
                    11,
                    item.createHead(headBucket,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof AngleBrush) {
            inv.setItem(
                    11,
                    item.createHead(headAngle,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof OverlayBrush) {
            inv.setItem(
                    11,
                    item.createHead(headOverlay,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof FractureBrush) {
            inv.setItem(
                    11,
                    item.createHead(headFracture,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof GradientBrush) {
            inv.setItem(
                    11,
                    item.createHead(headGradient,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof PaintBrush) {
            inv.setItem(
                    11,
                    item.createHead(headPaint,
                            1,
                            "&6Selected Brush type",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        }
        inv.setItem(
                20,
                item.create(XMaterial.ORANGE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.ORANGE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );

        // chance
        if (b instanceof SprayBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.GOLD_NUGGET.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Place chance: &e" + pb.getChance() + "%",
                            "___&7Left click to increase___&7Right click to decrease"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // axis
        if (b instanceof DiscBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.COMPASS.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Axis: &e" + pb.getAxis(),
                            "___&7Click to change"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }


        // thickness
        if (b instanceof OverlayBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.BOOK.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Layer Thickness: &e" + pb.getThickness(),
                            "___&7Left click to increase___&7Right click to decrease"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // angle settings
        if (b instanceof AngleBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.DAYLIGHT_DETECTOR.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Angle Check Distance: &e" + pb.getAngleDistance(),
                            "___&7Left click to increase___&7Right click to decrease"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );

            inv.setItem(
                    4,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    13,
                    item.create(XMaterial.BLAZE_ROD.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Maximum Angle: &e" + pb.getMinHeightDifference() + "°",
                            "___&7Left click to increase___&7Right click to decrease___&7Shift click to change by 15"
                    )
            );
            inv.setItem(
                    22,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // fracture settings
        if (b instanceof FractureBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.DAYLIGHT_DETECTOR.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Fracture Check Distance: &e" + pb.getFractureDistance(),
                            "___&7Left click to increase___&7Right click to decrease"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // angle settings
        if (b instanceof GradientBrush) {
            inv.setItem(
                    4,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    13,
                    item.create(XMaterial.MAGMA_CREAM.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Mixing Strength: &e" + pb.getMixingStrength() + "%",
                            "___&7Left click to increase___&7Right click to decrease"
                    )
            );
            inv.setItem(
                    22,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        if (b instanceof SplatterBrush || b instanceof PaintBrush || b instanceof GradientBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.BLAZE_POWDER.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Falloff Strength: &e" + pb.getFalloffStrength() + "%",
                            "___&7Left click to increase___&7Right click to decrease"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }


        // Size
        inv.setItem(
                5,
                item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );
        inv.setItem(
                14,
                item.create(XMaterial.BROWN_MUSHROOM.parseMaterial(),
                        (short) 0,
                        1,
                        "&6Brush Size: &e" + pb.getBrushSize(),
                        "___&7Left click to increase___&7Right click to decrease___&7Shift click to change by 10"
                )
        );
        inv.setItem(
                23,
                item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );

        // Mask toggle
        if (pb.isMaskEnabled()) {
            inv.setItem(
                    6,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    15,
                    item.create(XMaterial.JACK_O_LANTERN.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Mask",
                            "&a&lEnabled______&7Click to toggle"
                    )
            );
            inv.setItem(
                    24,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        } else {
            inv.setItem(
                    6,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    15,
                    item.create(XMaterial.PUMPKIN.parseMaterial(), (short) 0, 1, "&6Mask", "&c&lDisabled______&7Click to toggle")
            );
            inv.setItem(
                    24,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // Surface Mode toggle
        if (pb.isSurfaceModeEnabled()) {
            inv.setItem(
                    7,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    16,
                    item.create(XMaterial.LIGHT_WEIGHTED_PRESSURE_PLATE.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Surface Mode",
                            "&a&lEnabled______&7Click to toggle"
                    )
            );
            inv.setItem(
                    25,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        } else {
            inv.setItem(
                    7,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    16,
                    item.create(XMaterial.LIGHT_WEIGHTED_PRESSURE_PLATE.parseMaterial(),
                            (short) 0,
                            1,
                            "&6Surface Mode",
                            "&c&lDisabled______&7Click to toggle"
                    )
            );
            inv.setItem(
                    25,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // Place Block
        for (int x = 37; x <= 41; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.YELLOW_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.YELLOW_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }
        for (int x = 46; x <= 50; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.BARRIER.parseMaterial(), (short) 0, 1, "&cEmpty Slot", "___&7Click with a block to set")
            );
        }
        int x = 46;
        int size = pb.getBlocks().size();
        for (BlockType bt : pb.getBlocks()) {
            Material mat = bt.getMaterial();
            short data = bt.getData();
            int chance = (int) Math.floor(100 / size);
            if (chance > 64) {
                inv.setItem(
                        x,
                        item.create(mat,
                                data,
                                1,
                                "&aSlot " + (x - 45) + " &7" + (int) Math.floor(100 / size) + "%",
                                "___&7Left click with a block to change___&7Right click to clear"
                        )
                );
            } else {
                inv.setItem(
                        x,
                        item.create(mat,
                                data,
                                (int) Math.floor(100 / size),
                                "&aSlot " + (x - 45) + " &7" + (int) Math.floor(100 / size) + "%",
                                "___&7Left click with a block to change___&7Right click to clear"
                        )
                );
            }
            x++;
        }

        // Mask Block
        inv.setItem(
                43,
                item.create(XMaterial.YELLOW_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.YELLOW_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );
        BlockType bt = pb.getMask();
        inv.setItem(
                52,
                item.create(bt.getMaterial(), bt.getData(), 1, "&6Current Mask", "___&7Left click with a block to change")
        );
    }

}
