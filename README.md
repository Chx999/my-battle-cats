# my-battle-cats

一个用于练手的 **Java + LibGDX** 入门项目（灵感来自《猫咪大战争》）。

> 目标：先做出可运行的最小版本，再逐步增加功能。  
> 当前阶段：基础战场 + 出兵 + 碰撞阻挡 + 基础战斗（攻击/扣血/死亡移除）。

---

## 运行方式（IntelliJ）

1. 用 IntelliJ 打开项目根目录 `my-battle-cats`
2. 导入/同步 Gradle（Load Gradle Project）
3. 在 Gradle 面板中运行：
   - `lwjgl3 > Tasks > application > run`

运行成功后：
- 按 `L` 生成我方单位（蓝色，从右往左）
- 按 `A` 生成敌方单位（红色，从左往右）

---

## 项目结构（当前）

```text
my-battle-cats/
├─ assets/
│  └─ badlogic.jpg
├─ core/
│  ├─ build.gradle
│  └─ src/main/java/com/chx/game/
│     ├─ MainGame.java
│     ├─ BattleScreen.java
│     ├─ Unit.java
│     └─ Base.java
├─ lwjgl3/
│  ├─ build.gradle
│  └─ src/main/java/com/chx/game/lwjgl3/
│     └─ Lwjgl3Launcher.java
├─ build.gradle
└─ settings.gradle
```

---

## 文件职责说明

### `assets/`
资源目录，后续存放图片、音效、字体、配置文件等。

---

### `core/`（核心逻辑模块）
跨平台的游戏逻辑都放这里。

- `MainGame.java`  
  游戏主类，启动后切换到 `BattleScreen`。

- `BattleScreen.java`  
  主战场：处理输入、更新单位、绘制地面/基地/单位。

- `Unit.java`  
  单位类（我方/敌方共用）。目前包含：位置、速度、阵营、生命值、攻击力、攻击冷却、移动与攻击逻辑。

- `Base.java`  
  基地类，目前包含：基地坐标与血量（后续可扩展胜负判定）。

- `core/build.gradle`  
  `core` 模块自己的构建配置（Java 插件 + gdx 核心依赖）。

---

### `lwjgl3/`（桌面启动模块）
负责把 `core` 的逻辑在 PC 窗口中跑起来。

- `Lwjgl3Launcher.java`  
  桌面端入口 `main()`，设置窗口标题和分辨率并启动游戏。

- `lwjgl3/build.gradle`  
  桌面端依赖和运行入口配置。

---

### 根目录文件

- `settings.gradle`  
  声明多模块项目，并包含 `core` 与 `lwjgl3`。

- `build.gradle`（根）  
  全局配置（如依赖仓库 `mavenCentral()`），供子模块共用。

---

## Gradle 是什么？

可以把 **Gradle** 理解为 Java 项目的“自动管家/构建工具”：

1. 下载依赖（如 LibGDX）
2. 编译代码
3. 运行程序
4. 打包发布

在这个项目里，Gradle 还负责管理多模块结构（`core` + `lwjgl3`）。

---

## 开发约定（练手模式）

这个项目以“你自己动手写”为主：

- 尽量先自己实现
- 遇到卡点再给提示
- 默认提供思路、拆解和检查点
- **除非你明确要求，否则不直接把完整代码一次性写完**

---

## 当前已实现

- 基础战场画面
- 按键出兵（L=友方，A=敌方）
- 单位在单线地图上相向移动
- 单位接近敌人后会停止前进（基础碰撞阻挡）
- 单位会按攻击间隔互相攻击并扣血
- 单位血量归零后会被移除

---

## 下一步建议（你可自行实现）

- [x] 修改敌我方位置
- [x] 单位碰撞后停止前进
- [x] 互相攻击并扣血
- [x] 单位死亡移除
- [ ] 敌人自动波次刷新
- [ ] 基地掉血 + 胜负判定

