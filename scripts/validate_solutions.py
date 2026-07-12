from __future__ import annotations

import re
import subprocess
import tempfile
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]


def compile_java(source: Path) -> None:
    text = source.read_text(encoding="utf-8")
    match = re.search(r"\b(?:public\s+)?class\s+([A-Za-z_$][\w$]*)", text)
    if not match:
        raise RuntimeError(f"No Java class found in {source.relative_to(ROOT)}")
    with tempfile.TemporaryDirectory() as directory:
        target = Path(directory) / f"{match.group(1)}.java"
        target.write_text(text, encoding="utf-8")
        result = subprocess.run(["javac", "-encoding", "UTF-8", str(target)], capture_output=True, text=True)
        if result.returncode:
            raise RuntimeError(f"{source.relative_to(ROOT)}\n{result.stderr}")


def compile_cpp(source: Path) -> None:
    with tempfile.TemporaryDirectory() as directory:
        result = subprocess.run(
            ["g++", "-std=c++17", "-fsyntax-only", str(source)],
            cwd=directory,
            capture_output=True,
            text=True,
        )
        if result.returncode:
            raise RuntimeError(f"{source.relative_to(ROOT)}\n{result.stderr}")


def main() -> int:
    failures: list[str] = []
    sources = sorted(ROOT.rglob("*.java")) + sorted(ROOT.rglob("*.cc")) + sorted(ROOT.rglob("*.cpp"))
    for source in sources:
        try:
            compile_java(source) if source.suffix == ".java" else compile_cpp(source)
        except RuntimeError as error:
            failures.append(str(error))
    if failures:
        raise SystemExit("\n\n".join(failures))
    print(f"Validated {len(sources)} compiled solutions.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
