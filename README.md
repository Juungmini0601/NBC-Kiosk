# 내일 배움 캠프 키오스크 과제 구현

## 요구사항

[내일 배움 캠프 키오스크 과제 구현 요구사항](https://teamsparta.notion.site/Spring-6-CH-2-1ad2dc3ef51480b38a2afd0b5b6c0069) 참고

## 개발 환경

- Java 17 (Temurin17)

## 주요 기능

- 메뉴 목록 조회
- 장바구니
- 주문
    - 할인

## 패키지 구조

- baisc: 필수 기능 구현 디렉토리
    - level1
    - level2
    - level3
    - level4
    - level5
- challenge: 도전 기능 구현 디렉토리
    - level1
    - level2

```plaintext
├── Main.java
├── basic # 필수 기능
│   ├── level1
│   │   └── Main.java
│   ├── level2
│   │   ├── Main.java
│   │   └── MenuItem.java
│   ├── level3
│   │   ├── Kiosk.java
│   │   ├── Main.java
│   │   └── MenuItem.java
│   ├── level4
│   │   ├── Kiosk.java
│   │   ├── Main.java
│   │   ├── Menu.java
│   │   └── MenuItem.java
│   └── level5
│       ├── Kiosk.java
│       ├── Main.java
│       ├── Menu.java
│       └── MenuItem.java
└── challenge # 도전 기능
    ├── level1
    │   ├── Kiosk.java
    │   ├── Main.java
    │   ├── cart
    │   │   ├── Cart.java
    │   │   └── CartConstant.java
    │   ├── menu
    │   │   ├── MainMenuConstant.java
    │   │   ├── Menu.java
    │   │   ├── MenuItem.java
    │   │   └── SelectMenuItemConstant.java
    │   ├── order
    │   │   └── OrderConstant.java
    │   └── util
    │       └── ConsoleIOUtil.java
    └── level2
        ├── Kiosk.java
        ├── Main.java
        ├── command
        │   ├── Command.java
        │   ├── MainMenuCommandFactory.java
        │   ├── MainMenuExitCommand.java
        │   ├── OrderCancelCommand.java
        │   ├── OrderCommand.java
        │   └── SelectMenuItemCommand.java
        ├── domain
        │   ├── cart
        │   │   └── Cart.java
        │   ├── discount
        │   │   └── DisCountType.java
        │   ├── menu
        │   │   ├── Menu.java
        │   │   └── MenuItem.java
        │   └── order
        │       └── Order.java
        └── util
            └── ScannerHolder.java
```

## Overall Class Diagram - Challenge Level2

### Domain

![Image](https://github.com/user-attachments/assets/e661c6a8-1b2a-441c-82bc-e07053425544)

### Kisok Command

![Image](https://github.com/user-attachments/assets/052a1a23-547a-4d30-9636-6628fa52df73)

### TIL

https://luxurious-syzygy-94d.notion.site/1b5e21d1cc3d80a5823ade5b233e5b4e?pvs=74