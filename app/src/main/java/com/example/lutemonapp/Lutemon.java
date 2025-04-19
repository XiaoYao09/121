package com.example.lutemonapp;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int speed;
    protected int id;

    // 新增：记录初始属性
    private int baseAttack;
    private int baseDefense;
    private int baseMaxHealth;
    private int baseSpeed;

    private static int idCounter = 0;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth, int speed) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.experience = 0;
        this.speed = speed;
        this.id = idCounter++;

        // 保存初始属性
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.baseMaxHealth = maxHealth;
        this.baseSpeed = speed;
    }

    // 攻击力（包含经验加成）
    public int attack() {
        return attack + experience;
    }

    // 受到攻击，计算伤害
    public void defense(int attackValue) {
        int damage = attackValue - defense;
        if (damage > 0) {
            health -= damage;
        }
        if (health < 0) {
            health = 0;
        }
    }

    // 判断是否死亡
    public boolean isDead() {
        return health <= 0;
    }

    // 胜利后增加经验 + 所有属性
    public void gainExperience() {
        experience += 1;
        attack += 1;
        defense += 1;
        maxHealth += 1;
        speed += 1;
        health = maxHealth;
    }

    // ❗死亡后属性归零（调用此方法即可）
    public void resetStats() {
        experience = 0;
        attack = baseAttack;
        defense = baseDefense;
        maxHealth = baseMaxHealth;
        speed = baseSpeed;
        health = maxHealth;
    }

    // 返回 Home 时恢复生命
    public void restoreHealth() {
        this.health = maxHealth;
    }

    // ------------------------------
    // 🔓 Getter 方法，供外部访问属性
    // ------------------------------
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getSpeed() {
        return speed;
    }

    public int getId() {
        return id;
    }

    // 你可以根据需要添加一个 getImage() 抽象方法，子类实现它来返回对应图片
    public abstract int getImage();
}


