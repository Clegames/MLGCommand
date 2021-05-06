package net.clegames.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material) {

        itemStack = new ItemStack(material);
        itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(Material material, Integer amount) {

        itemStack = new ItemStack(material, amount);
        itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(Material material, Integer amount, short subid) {

        itemStack = new ItemStack(material, amount, subid);
        itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(Integer id, Integer amount) {
		
        itemStack = new ItemStack(id, amount);
        itemMeta = this.itemStack.getItemMeta();
    }


    public ItemBuilder(Integer id, Integer amount, short subid) {

        itemStack = new ItemStack(id, amount, subid);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemStack build() {

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public ItemBuilder setDisplayName(String displayName) {

        meta.setDisplayName(displayName);

        return this;
    }

    public ItemBuilder setLore(String... lore) {

        meta.setLore(Arrays.asList(lore));

        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flag) {

        meta.addItemFlags(flag);

        return this;
    }

    public ItemBuilder setUnbreakable(Boolean unbreakable) {

        meta.spigot().setUnbreakable(unbreakable);

        return this;
    }

    public ItemBuilder addEnchant(org.bukkit.enchantments.Enchantment bukkitEnchant, Integer level) {

        meta.addEnchant(bukkitEnchant, level, true);

        return this;
    }

    public ItemBuilder setSkullOwner(String name) {

        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwner(name);

        return this;
    }


    public ItemBuilder addEnchantments(Enchantment... enchantments) {
        for (Enchantment enchantment : enchantments) {

            meta.addEnchant(enchantment.getEnchantment(), enchantment.getLevel(), true);
        }

        return this;
    }

    public class Enchantment {

        private final Integer level;
        private final org.bukkit.enchantments.Enchantment enchantment;

        public Enchantment(org.bukkit.enchantments.Enchantment enchantment, Integer level) {

            this.level = level;
            this.enchantment = enchantment;
        }

        public Integer getLevel() {

            return level;
        }

        public org.bukkit.enchantments.Enchantment getEnchantment() {

            return enchantment;
        }
    }
}
